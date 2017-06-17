package it.uniroma3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.model.Autore;
import it.uniroma3.repository.AutoreRepository;

public class AutoreService {
	
	private AutoreRepository autoreRepository;
	private EntityTransaction tx;
	public AutoreService(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		AutoreRepository autoreRepository = new AutoreRepository(em);
		this.autoreRepository = autoreRepository;
		this.tx = tx;
	}
	
	public Autore inseriscAutore(Autore autore){
		tx.begin();
		autoreRepository.save(autore);
		tx.commit();
		return autore;
	}
	
	public List<Autore> getAutori(){
		tx.begin();
		List<Autore> autori = autoreRepository.findAll(); 
		tx.commit();
		return autori;
	}

	public Autore getAutoreDaId(Long id) {
		tx.begin();
		Autore autore = autoreRepository.findOne(id);
		tx.commit();
		return autore;
	}
	
	public void eliminaAutore(Long id){
		Autore toDelete = this.getAutoreDaId(id);
		tx.begin();
		this.autoreRepository.delete(toDelete);
		tx.commit();
	}

}
