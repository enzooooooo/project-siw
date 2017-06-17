package it.uniroma3.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.model.Utente;
import it.uniroma3.repository.UtenteRepository;

public class UtenteService {
	private UtenteRepository utenteRepository;
	private EntityTransaction tx;
	public UtenteService(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		UtenteRepository utenteRepository = new UtenteRepository(em);
		this.utenteRepository = utenteRepository;
		this.tx = tx;
	}
	
	public Utente inseriscUtente(Utente utente){
		tx.begin();
		utenteRepository.save(utente);
		tx.commit();
		return utente;
	}
	
	public Map<String,Utente> getUtenti(){
		tx.begin();
		List<Utente> utenti = utenteRepository.findAll(); 
		Map<String,Utente> map = new HashMap<String,Utente>();
		for (Utente u : utenti) map.put(u.getUsername(),u);
		tx.commit();
		return map;
	}

	public Utente getUtenteDaId(Long id) {
		tx.begin();
		Utente utente = utenteRepository.findOne(id);
		tx.commit();
		return utente;
	}
	
	public void eliminaUtente(Long id){
		Utente toDelete = this.getUtenteDaId(id);
		tx.begin();
		this.utenteRepository.delete(toDelete);
		tx.commit();
	}
	
	public Utente login(String username, String password){
		Map<String,Utente> utenti = getUtenti();
		Utente utente = utenti.get(username);
		if (utente != null && utente.getPassword() == password){
			return utente;
		}
		else
			return null;
	}
}
