package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.model.Amministratore;
import it.uniroma3.service.AmministratoreService;

@WebServlet("/controllerAmministratore")
public class ControllerAmministratore extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Amministratore amministratore = new Amministratore();
		AmministratoreService amministratoreService = new AmministratoreService();
		String nextPage = "/areaAmministratori.jsp";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		amministratore = amministratoreService.login(username, password);
		if(amministratore != null){
			request.setAttribute("amministratore", amministratore);
			nextPage = "/gestioneGalleria.jsp";
		}
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		
	}

}
