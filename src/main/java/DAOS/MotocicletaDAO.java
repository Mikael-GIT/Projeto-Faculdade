package DAOS;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Motocicleta;

public class MotocicletaDAO {
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

	  public Motocicleta salvar(Motocicleta motocicleta) throws Exception {
	    EntityManager entityManager = getEntityManager();
	    try {
	      entityManager.getTransaction().begin();
	      System.out.println("Salvando a motocicleta");
	      if(motocicleta.getId() == null) {
	        entityManager.persist(motocicleta);
	      } else {
	        motocicleta = entityManager.merge(motocicleta);
	      }
	      entityManager.getTransaction().commit();
	    } finally {
	      entityManager.close();
	    }
	    return motocicleta;
	  }

	  public void excluir(Long id) {
	    EntityManager entityManager = getEntityManager();
	    try {
	      entityManager.getTransaction().begin();
	      Motocicleta motocicleta = entityManager.find(Motocicleta.class, id);
	      entityManager.remove(motocicleta);
	      entityManager.getTransaction().commit();
	    } finally {
	      entityManager.close();
	    }
	  }


	  public Motocicleta consultarPorId(Long id) {
	    EntityManager entityManager = getEntityManager();
	    Motocicleta motocicleta = null;
	    try {
	    	entityManager.getTransaction().begin();
	        motocicleta = entityManager.find(Motocicleta.class, id);
	    } finally {
	    	entityManager.getTransaction().commit();
	    }
	    return motocicleta;
	  }
}
