package br.org.base.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.org.base.model.Venda;

/**
 * Session Bean implementation class VendaService
 */
@Stateless
@Named
public class VendaService {


	@Inject
	private EntityManager em;
	
	
    public List<Venda>  list() {
        Query q =  em.createNativeQuery("Venda.find");
        return q.getResultList();
    }
    
    public void insere(Venda v){
    	em.persist(v);
    }

}
