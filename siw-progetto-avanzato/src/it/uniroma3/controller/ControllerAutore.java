package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.model.Autore;
import it.uniroma3.service.AutoreService;

@WebServlet("/controllerAutore")
public class ControllerAutore extends HttpServlet {

	private static final long serialVersionUID = 1L;
	//commento di prova
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		AutoreService service = new AutoreService();
		Autore autore = new Autore();
		autore.setNome(request.getParameter("nome"));
		autore.setCognome(request.getParameter("cognome"));
		service.inseriscAutore(autore);
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/MostraDati.jsp");
		rd.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 
	}
	
}
