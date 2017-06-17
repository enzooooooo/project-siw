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
		Quadro opera = new Quadro();
		OperaValidator operaValidator = new OperaValidator();
		String nextPage = "/MostraDatiOpera.jsp";
		request.setAttribute("opera", opera);
		if(!operaValidator.validate(request))
			nextPage = "/nuovoOpera.jsp";
		service.inseriscOpera(opera);
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		OperaService service = new OperaService();
		List<Quadro> opere = service.getOpere();
		request.setAttribute("opere", opere);
		String nextPage = "/vediOpere.jsp";
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		 
	}

}
