package it.uniroma3.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.model.Autore;

public class ArtistaValidator {

	
	public ArtistaValidator(){
		
	}
	
	public boolean validate(HttpServletRequest request) {
		boolean tuttoOk = true;
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String nazionalita = request.getParameter("nazionalita");
		String dataNascita = request.getParameter("dataN");
		String dataMorte = request.getParameter("dataM");
		Autore autore = (Autore) request.getAttribute("artista");
		
		//HttpSession session = request.getSession();
		request.setAttribute("nome", nome);
		request.setAttribute("desc",cognome);
		request.setAttribute("dataN",dataNascita);
		request.setAttribute("dataM",dataMorte);
		request.setAttribute("prezzo",nazionalita);
		
		if (nome.isEmpty() || nome == null){
			tuttoOk = false;
			request.setAttribute("errnome", "Campo obbligatorio");
			}
		else
			autore.setNome(nome);
		
		if (cognome.isEmpty() || cognome == null){
			tuttoOk = false;
			request.setAttribute("errdesc", "Campo obbligatorio");
		}
		else
			autore.setCognome(cognome);
		
		if (nazionalita.isEmpty() || nazionalita == null){
			tuttoOk = false;
			request.setAttribute("errprezzo", "Campo obbligatorio");
		}
		else{
			autore.setNazionalita(nazionalita);
		}
		if (dataNascita.isEmpty() || dataNascita == null){
			tuttoOk = false;
			request.setAttribute("errdataS", "Campo obbligatorio");
		}
		else {
				try{
					DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
					Date dataScadenza = (Date) dateFormat.parse(dataNascita);
						autore.setDataNascita(dataScadenza);
					
				}
				catch (ParseException e){
					request.setAttribute("errdataS", "Data non valida");
					tuttoOk = false;
				}
		}
		
		if (dataMorte.isEmpty() || dataMorte == null){
			tuttoOk = false;
			request.setAttribute("errdataS", "Campo obbligatorio");
		}
		else {
				try{
					DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
					Date dataScadenza = (Date) dateFormat.parse(dataMorte);
						autore.setDataMorte(dataScadenza);
				}
				catch (ParseException e){
					request.setAttribute("errdataS", "Data non valida");
					tuttoOk = false;
				}
		}
		
		return tuttoOk;
	}
}
