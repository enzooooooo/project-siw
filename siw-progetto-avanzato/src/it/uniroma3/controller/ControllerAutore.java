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


import it.uniroma3.model.Autore;
import it.uniroma3.service.AutoreService;
import it.uniroma3.validator.ArtistaValidator;

@WebServlet("/controllerArtista")
public class ControllerAutore extends HttpServlet {

	private static final long serialVersionUID = 1L;
	//commento di prova
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		AutoreService service = new AutoreService();
		Autore autore = new Autore();
		ArtistaValidator artistaValidator = new ArtistaValidator();
		String nextPage = "/nuovoArtista.jsp";
		request.setAttribute("artista", autore);
		if(artistaValidator.validate(request)){
			service.inseriscAutore(autore);
			nextPage = "/MostraDati.jsp";
		}
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		AutoreService service = new AutoreService();
		String nextPage = "/vediArtisti.jsp";
		if (request.getParameter("id") == null){
			if (request.getParameter("op").compareTo("1") == 0)
				nextPage = "/nuovaOpera.jsp";
			else if (request.getParameter("op").compareTo("2") == 0)
				request.setAttribute("isUtente", true);
			}
		else{ 
			Long id =Long.parseLong(request.getParameter("id"));
			service.eliminaAutore(id);
		}
		List<Autore> autori = service.getAutori();
		request.setAttribute("artisti", autori);
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		 
	}
	
}
