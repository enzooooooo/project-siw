package it.uniroma3.repository;

import javax.persistence.EntityManager;

import it.uniroma3.model.Amministratore;

public class AmministratoreRepository extends CrudRepositoryJPA<Amministratore> {

	public AmministratoreRepository(EntityManager em) {
		super(em, Amministratore.class);
	}

}
