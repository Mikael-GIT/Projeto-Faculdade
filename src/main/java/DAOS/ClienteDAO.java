package DAOS;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Cliente;

public class ClienteDAO {
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		try {
			factory = Persistence.createEntityManagerFactory("loja");
			entityManager = factory.createEntityManager();
		} finally {
			// factory.close();
		}
		return entityManager;
	}

	public Cliente salvar(Cliente cliente) throws Exception {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			System.out.println("Salvando o cliente");
			if (cliente.getId() == null) {
				entityManager.persist(cliente);
			} else {
				cliente = entityManager.merge(cliente);
			}
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return cliente;
	}

	public void excluir(Long id) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			Cliente cliente = entityManager.find(Cliente.class, id);
			System.out.println("Excluindo os dados de: " + cliente.getNome());
			entityManager.remove(cliente);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	public Cliente consultarPorId(Long id) {
		EntityManager entityManager = getEntityManager();
		Cliente cliente = null;
		try {
			entityManager.getTransaction().begin();
			cliente = entityManager.find(Cliente.class, id);
		} finally {
			entityManager.getTransaction().commit();
		}
		return cliente;
	}
}
