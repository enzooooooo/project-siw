package it.uniroma3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.model.Quadro;
import it.uniroma3.repository.QuadroRepository;

public class OperaService {
	
	private QuadroRepository quadroRepository;
	private EntityTransaction tx;
	public OperaService(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		QuadroRepository quadroRepository = new QuadroRepository(em);
		this.quadroRepository = quadroRepository;
		this.tx = tx;
	}
	
	public Quadro inseriscOpera(Quadro quadro){
		tx.begin();
		quadroRepository.save(quadro);
		tx.commit();
		return quadro;
	}
	
	public List<Quadro> getOpere(){
		tx.begin();
		List<Quadro> quadri = quadroRepository.findAll(); 
		tx.commit();
		return quadri;
	}

	public Quadro getQuadroDaId(Long id) {
		tx.begin();
		Quadro quadro = quadroRepository.findOne(id);
		tx.commit();
		return quadro;
	}
	
	public void eliminaQuadro(Long id){
		Quadro toDelete = this.getQuadroDaId(id);
		tx.begin();
		this.quadroRepository.delete(toDelete);
		tx.commit();
	}

}
