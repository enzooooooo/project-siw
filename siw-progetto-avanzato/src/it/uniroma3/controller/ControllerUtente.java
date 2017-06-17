package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.model.Utente;
import it.uniroma3.service.UtenteService;
import it.uniroma3.validator.UtenteValidator;

@WebServlet("/controllerUtente")
public class ControllerUtente extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Utente utente = new Utente();
		UtenteService utenteService = new UtenteService();
		String nextPage = "/index.jsp";
		if (request.getAttribute("comand") != null){
			String username = (String) request.getAttribute("username");
			String password = (String) request.getAttribute("password");
			utente = utenteService.login(username, password);
			if(utente != null){
				nextPage = "/indexUtente.jsp";
			}
		}
		else {
			UtenteValidator utenteValidator = new UtenteValidator();
			request.setAttribute("utente", utente);
			if(utenteValidator.validate(request)){
				utenteService.inseriscUtente(utente);
				nextPage = "/indexUtente.jsp";
			}
			
		}
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		
	}
}
