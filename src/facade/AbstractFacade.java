/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import connection.Conexao;

/**
 * 
 * @author jonas
 */
public abstract class AbstractFacade<T> {

	private Class<T> entityClass = null;
	private static EntityManager em = null;
	private String persistenceUnit = null;

	public AbstractFacade() {
	}

	public AbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public void setPersistenceUnit(String persistenceUnit) {
		this.persistenceUnit = persistenceUnit;
	}

	// private EntityManager getConnection(String persistenceUnit) {
	// EntityManagerFactory emf =
	// Persistence.createEntityManagerFactory(persistenceUnit);
	// em = emf.createEntityManager();
	// return em;
	// }

	protected EntityManager getEntityManager() {
		if (em == null) {
			// return getConnection(persistenceUnit);
			em = Conexao.getConnection(persistenceUnit);
		} else {
			if (!em.isOpen())
				em = Conexao.getConnection(persistenceUnit);
		}
		return em;
	}

	// protected abstract EntityManager getEntityManager();

	public void create(T t) {
		try {
			getEntityManager().getTransaction().begin();

			getEntityManager().persist(t);

			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	// public void create(T entity) {
	// try {
	// getEntityManager().getTransaction().begin();
	//
	// getEntityManager().persist(entity);
	//
	// getEntityManager().getTransaction().commit();
	// } catch (Exception e) {
	// getEntityManager().getTransaction().rollback();
	// e.printStackTrace();
	// }
	// }

	public void edit(T entity) {
		try {
			getEntityManager().getTransaction().begin();

			getEntityManager().merge(entity);

			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	// public void edit(T entity) {
	// try {
	// getEntityManager().getTransaction().begin();
	//
	// getEntityManager().merge(entity);
	//
	// getEntityManager().getTransaction().commit();
	// } catch (Exception e) {
	// getEntityManager().getTransaction().rollback();
	// e.printStackTrace();
	// }
	// }

	public void remove(T entity) {
		try {
			getEntityManager().getTransaction().begin();

			getEntityManager().remove(getEntityManager().merge(entity));

			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	// public void remove(T entity) {
	// try {
	// getEntityManager().getTransaction().begin();
	//
	// getEntityManager().remove(getEntityManager().merge(entity));
	//
	// getEntityManager().getTransaction().commit();
	// } catch (Exception e) {
	// getEntityManager().getTransaction().rollback();
	// e.printStackTrace();
	// }
	//
	// }

	public T find(Object id) {
		return getEntityManager().find(entityClass, id);
	}

	public List<T> findAll() {
		CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder()
				.createQuery(entityClass);
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getResultList();
	}

	// public List<T> findAll() {
	// CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder()
	// .createQuery(entityClass);
	// cq.select(cq.from(entityClass));
	// return getEntityManager().createQuery(cq).getResultList();
	// /*
	// * Query q = em.createQuery("select p from Pessoa p"); List<Pessoa> lp =
	// * q.getResultList(); System.out.println(lp);
	// */
	// }

	// public List<T> findRange(int[] range) {
	// CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder()
	// .createQuery(entityClass);
	// cq.select(cq.from(entityClass));
	// Query q = getEntityManager().createQuery(cq);
	// q.setMaxResults(range[1] - range[0]);
	// q.setFirstResult(range[0]);
	// return q.getResultList();
	// }

	// public int count() {
	// CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder()
	// .createQuery(entityClass);
	// javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
	// cq.select(getEntityManager().getCriteriaBuilder().count(rt));
	// javax.persistence.Query q = getEntityManager().createQuery(cq);
	// return ((Long) q.getSingleResult()).intValue();
	// }

	public void close() {
		em.close();
		em = null;
	}
}
