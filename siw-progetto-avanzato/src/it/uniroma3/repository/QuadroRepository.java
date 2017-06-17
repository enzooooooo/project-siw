package it.uniroma3.repository;

import javax.persistence.EntityManager;

import it.uniroma3.model.Quadro;

public class QuadroRepository extends CrudRepositoryJPA<Quadro> {

	public QuadroRepository(EntityManager em) {
		super(em, Quadro.class);
	}

}
