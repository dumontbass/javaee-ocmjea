package br.org.base.data;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;


@Named
public class Crud<T> {
	
	@Inject
	EntityManager em;

	public T find(long id, Class clazz){
	
		String name = clazz.getSimpleName() + ".find";
		Query query =  em.createNamedQuery(name, clazz);
		query.setParameter("id", id);
		T object = (T) query.getSingleResult();
		return object;
	}

	public List<T> findAll(Class clazz) {
		String name = clazz.getSimpleName() + ".findAll";
		Query query =  em.createNamedQuery(name);
		return query.getResultList();
	}
	
	public void persist(Object o){
		em.persist(o);
	}
	
}
