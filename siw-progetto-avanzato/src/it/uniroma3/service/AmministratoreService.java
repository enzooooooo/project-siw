package it.uniroma3.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.model.Amministratore;
import it.uniroma3.repository.AmministratoreRepository;

public class AmministratoreService {
	
	
	private AmministratoreRepository amministratoreRepository;
	private EntityTransaction tx;
	public AmministratoreService(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		AmministratoreRepository amministratoreRepository = new AmministratoreRepository(em);
		this.amministratoreRepository = amministratoreRepository;
		this.tx = tx;
	}
	
	public Amministratore inseriscAmministratore(Amministratore amministratore){
		tx.begin();
		amministratoreRepository.save(amministratore);
		tx.commit();
		return amministratore;
	}
	
	public Map<String,Amministratore> getAmministratori(){
		tx.begin();
		List<Amministratore> amministratori = amministratoreRepository.findAll(); 
		Map<String,Amministratore> map = new HashMap<String,Amministratore>();
		for (Amministratore u : amministratori) map.put(u.getUsername(),u);
		tx.commit();
		return map;
	}

	public Amministratore getAmministratoreDaId(Long id) {
		tx.begin();
		Amministratore amministratore = amministratoreRepository.findOne(id);
		tx.commit();
		return amministratore;
	}
	
	public void eliminaAmministratore(Long id){
		Amministratore toDelete = this.getAmministratoreDaId(id);
		tx.begin();
		this.amministratoreRepository.delete(toDelete);
		tx.commit();
	}
	
	
	public Amministratore login(String username, String password){
		Map<String,Amministratore> amministratori = getAmministratori();
		Amministratore amministratore = amministratori.get(username);
		if (amministratore != null && amministratore.getPassword().compareTo(password)==0){
			return amministratore;
		}
		else
			return null;
	}


}
