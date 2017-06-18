package it.uniroma3.validator;



import javax.servlet.http.HttpServletRequest;

import it.uniroma3.model.Autore;
import it.uniroma3.model.Quadro;
import it.uniroma3.service.AutoreService;

public class OperaValidator {

	
	public OperaValidator(){
		
	}
	
	public boolean validate(HttpServletRequest request) {
		boolean tuttoOk = true;
		AutoreService artistaService = new AutoreService();
		String nome = request.getParameter("titolo");
		String anno = request.getParameter("anno");
		String tecnica = request.getParameter("tecnica");
		String dimensione = request.getParameter("dimensione");
		String idArtista = request.getParameter("artista");
		Quadro opera = (Quadro) request.getAttribute("opera");
		Autore autore;
		try{
			Long id = Long.parseLong(idArtista);
			autore = artistaService.getAutoreDaId(id);
			opera.setAutore(autore);
			} 
			catch (NumberFormatException e){
				tuttoOk = false;
			}		
		
		request.setAttribute("titolo", nome);
		request.setAttribute("anno",anno);
		request.setAttribute("dimensione",dimensione);
		request.setAttribute("tecnica",tecnica);
		
		if (nome.isEmpty() || nome == null){
			tuttoOk = false;
			}
		else
			opera.setTitolo(nome);
		
		if (anno.isEmpty() || anno == null){
			tuttoOk = false;
		}
		else
			try{
				int annoF = Integer.parseInt(anno);
				opera.setAnno(annoF);
				} 
				catch (NumberFormatException e){
					request.setAttribute("errAnno", " -- Deve essere un numero !");
					tuttoOk = false;
				}
		
		if (tecnica.isEmpty() || tecnica == null){
			tuttoOk = false;
		}
		else{
			opera.setTecnica(tecnica);
		}
		if (dimensione.isEmpty() || dimensione == null){
			tuttoOk = false;
		}
		else {
			try{
			int dimensioneF = Integer.parseInt(dimensione);
			opera.setAnno(dimensioneF);
			} 
			catch (NumberFormatException e){
				request.setAttribute("errDimensione", "-- Deve essere un numero !");
				tuttoOk = false;
			}
		}
		
		return tuttoOk;
	}
}
