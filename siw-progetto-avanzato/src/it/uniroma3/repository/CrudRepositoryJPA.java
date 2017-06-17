package it.uniroma3.repository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
public class CrudRepositoryJPA<T> implements CrudRepository<T> {

	private EntityManager em;
	private Class<T> entityClass;
	
	public CrudRepositoryJPA(EntityManager em, Class<T> entityClass){
		this.em = em;
		this.entityClass = entityClass;
	}
	
	private String getClassName(){
		String fullClassName =this.entityClass.getCanonicalName();
		String className = fullClassName.substring(fullClassName.lastIndexOf('.'));
		return className;
	}
	
	@Override
	public T save(T entity) {
		Method getId = null;
		T persistentEntity = null;
		try{
		getId = this.entityClass.getMethod("getId");
		} catch (NoSuchMethodException | SecurityException e){
			e.printStackTrace();//supponiamo che ci sia sempre un metodo getId
		}
		try{
		if(getId.invoke(entity) == null){
			em.persist(entity);
			persistentEntity = entity;
		}
		else{
			persistentEntity = em.merge(entity);
		}
		}catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
			e.printStackTrace();
		}
		return persistentEntity;
	}

	@Override
	public T findOne(Long id) {
		return em.find(this.entityClass, id);
	}

	@Override
	public List<T> findAll() {
		String className = this.entityClass.getSimpleName();
		// String fullClassName e 
		TypedQuery<T> query = em.createQuery("SELECT a FROM "+className +" a",entityClass);
		return query.getResultList();
	}

	@Override
	public void delete(T Entity) {
		em.remove(Entity);
		
	}

	@Override
	public void deleteAll() {
		String className = this.entityClass.getCanonicalName();
		TypedQuery<T> query = em.createQuery("DELETE FROM "+className ,entityClass);
		query.executeUpdate();
	}
	
	protected EntityManager getEm(){
		return this.em;
	}

}
