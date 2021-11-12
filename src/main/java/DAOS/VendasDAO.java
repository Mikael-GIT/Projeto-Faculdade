package DAOS;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Venda;

public class VendasDAO {
	private EntityManager getEntityManager() {
	    EntityManagerFactory factory = null;
	    EntityManager entityManager = null;
	    try {
	      factory = Persistence.createEntityManagerFactory("loja");
	      entityManager = factory.createEntityManager();
	    } finally {
	      //factory.close();
	    }
	    return entityManager;
	  }

	  public Venda salvar(Venda venda) throws Exception {
	    EntityManager entityManager = getEntityManager();
	    try {
	      entityManager.getTransaction().begin();
	      if(venda.getId() == null) {
	        entityManager.persist(venda);
	      } else {
	        venda = entityManager.merge(venda);
	      }
	      entityManager.getTransaction().commit();
	    } finally {
	      entityManager.close();
	    }
	    return venda;
	  }

	  public void excluir(Long id) {
	    EntityManager entityManager = getEntityManager();
	    try {
	      entityManager.getTransaction().begin();
	      Venda venda = entityManager.find(Venda.class, id);
	      entityManager.remove(venda);
	      entityManager.getTransaction().commit();
	    } finally {
	      entityManager.close();
	    }
	  }


	  public Venda consultarPorId(Long id) {
	    EntityManager entityManager = getEntityManager();
	    Venda venda = null;
	    try {
	    	entityManager.getTransaction().begin();
	        venda = entityManager.find(Venda.class, id);
	    } finally {
	    	entityManager.getTransaction().commit();
	    }
	    return venda;
	  }
	 
}
