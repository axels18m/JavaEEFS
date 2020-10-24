package jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import dao.GenericDAO;

public abstract class GenericDAOJPAImpl<T, Id extends Serializable> implements GenericDAO<T, Id> 
{
	private Class<T> persistenceClass;
	
	@SuppressWarnings("unchecked")
	public GenericDAOJPAImpl()
	{
		/* Reflection */
		this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public T getById(Id id)
	{
		EntityManager manager = jpa();
		T obj = null;
		
		try { obj = (T) manager.find(persistenceClass, id); return obj; } finally { manager.close(); }
	}
	
	@Override
	public List<T> getAll()
	{
		EntityManager manager = jpa();
		List<T> listOfObjects = null;
		
		try {
			TypedQuery<T> query = manager.createNamedQuery("select o from " + persistenceClass.getSimpleName() + " o", persistenceClass);
			listOfObjects = query.getResultList();
			return listOfObjects;
			
		} finally {
			manager.close();
		}
	}
	
	public void delete(T obj)
	{
		EntityManager manager = jpa();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(manager.merge(obj));
			transaction.commit();
		
		} catch(PersistenceException e) {
			transaction.rollback();
			throw e;
		
		} finally {
			manager.close();
		}
	}
	
	public void save(T obj)
	{
		EntityManager manager = jpa();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(obj);
			transaction.commit();
		
		} catch(PersistenceException e) {
			transaction.rollback();
			throw e;
		
		} finally {
			manager.close();
		}
	}
	
	public void insert(T obj)
	{
		EntityManager manager = jpa();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(obj);
			transaction.commit();
		
		} catch(PersistenceException e) {
			transaction.rollback();
			throw e;
		
		} finally {
			manager.close();
		}
	}
	
	public static EntityManager jpa()
	{
		EntityManagerFactory factorySession = JPAHelper.getJPAFactory();
		EntityManager manager = factorySession.createEntityManager();
		return manager;
	}
}
