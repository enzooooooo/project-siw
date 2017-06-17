package it.uniroma3.repository;

import javax.persistence.EntityManager;

import it.uniroma3.model.Utente;

public class UtenteRepository extends CrudRepositoryJPA<Utente> {

	public UtenteRepository(EntityManager em) {
		super(em, Utente.class);
	}
	
	

}
