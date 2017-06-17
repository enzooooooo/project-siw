package it.uniroma3.repository;

import javax.persistence.EntityManager;

import it.uniroma3.model.Autore;

public class AutoreRepository extends CrudRepositoryJPA<Autore> {

	public AutoreRepository(EntityManager em) {
		super(em, Autore.class);
	}

}
