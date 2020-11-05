package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import dao.CategoriaDAO;
import entity.Categoria;

public class CategoriaDAOJPAImpl extends GenericDAOJPAImpl<Categoria, Integer> implements CategoriaDAO
{
	public Categoria getById(int isbn) 
	{
		EntityManagerFactory factorySession = JPAHelper.getJPAFactory();
		EntityManager manager = factorySession.createEntityManager();
		
		TypedQuery<Categoria> query = manager.createQuery("select l from Libro l where l.cat= " +isbn, Categoria.class);
		Categoria category = null;
		
		try { category = query.getSingleResult(); } catch(PersistenceException e) {manager.getTransaction().rollback(); } finally { manager.close(); }
		return category;
	}
}
