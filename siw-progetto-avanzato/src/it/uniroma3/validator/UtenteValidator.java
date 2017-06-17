package it.uniroma3.validator;


import javax.servlet.http.HttpServletRequest;

import it.uniroma3.model.Utente;

public class UtenteValidator {

	public boolean validate(HttpServletRequest request) {
		boolean tuttoOk = true;
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Utente utente = (Utente) request.getAttribute("utente");
		
		//HttpSession session = request.getSession();
		request.setAttribute("nome", nome);
		request.setAttribute("cognome",cognome);
		request.setAttribute("password",password);
		request.setAttribute("username",username);
		
		if (nome.isEmpty() || nome == null){
			tuttoOk = false;
			request.setAttribute("errnome", "Campo obbligatorio");
			}
		else
			utente.setNome(nome);
		
		if (cognome.isEmpty() || cognome == null){
			tuttoOk = false;
			request.setAttribute("errdesc", "Campo obbligatorio");
		}
		else
			utente.setCognome(cognome);
		
		if (username.isEmpty() || username == null){
			tuttoOk = false;
			request.setAttribute("errprezzo", "Campo obbligatorio");
		}
		else{
			utente.setUsername(username);
		}
		if (password.isEmpty() || password == null){
			tuttoOk = false;
			request.setAttribute("errdataS", "Campo obbligatorio");
		}
		else {
				utente.setPassword(password);
		}
		
		return tuttoOk;
	}
}
