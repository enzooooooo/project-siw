package it.uniroma3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.model.Quadro;
import it.uniroma3.service.OperaService;
import it.uniroma3.validator.OperaValidator;

@WebServlet("/controllerOpera")
public class ControllerOpera extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		OperaService service = new OperaService();
		String nextPage = "/nuovaOpera.jsp";
		if(request.getParameter("nomeRicerca") != null){
			nextPage = "/ricerca.jsp";
			List<Quadro> opere = service.getOpereFromNome(request.getParameter("nomeRicerca"));
			request.setAttribute("operePerNome", opere);
		}
		else if(request.getParameter("annoRicerca") != null){
			nextPage = "/ricerca.jsp";
			try{
				int annoF = Integer.parseInt(request.getParameter("annoRicerca"));
				List<Quadro> opere = service.getOpereFromAnno(annoF);
				request.setAttribute("operePerAnno", opere);
				} 
				catch (NumberFormatException e){
					request.setAttribute("errAnno", " -- Deve essere un numero !");
				}
		}
		else{
		
		Quadro opera = new Quadro();
		OperaValidator operaValidator = new OperaValidator();
		request.setAttribute("opera", opera);
		if(operaValidator.validate(request)){
			service.inseriscOpera(opera);
			nextPage = "/MostraDatiOpera.jsp";
		}
		}
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		OperaService service = new OperaService();
		String nextPage = "/vediOpere.jsp";
		if(request.getParameter("id") != null){
			Long id = Long.parseLong(request.getParameter("id"));
			service.eliminaQuadro(id);
		}
		if(request.getParameter("idArtista") == null)
		{
			List<Quadro> opere = service.getOpere();
			request.setAttribute("opere", opere);
		}
		else{
			List<Quadro> opere = service.getOpereFromArtista(Long.parseLong(request.getParameter("idArtista")));
			request.setAttribute("opere", opere);
		}
		if(request.getParameter("isUtente") != null)
			request.setAttribute("isUtente", true);
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		 
	}

}
