package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import dao.CategoriaDAO;
import entity.Categoria;

public class CategoriaDAOJPAImpl extends GenericDAOJPAImpl<Categoria, Integer> implements CategoriaDAO
{
	public Categoria getById(int category) 
	{
		EntityManagerFactory factorySession = JPAHelper.getJPAFactory();
		EntityManager manager = factorySession.createEntityManager();
		
		TypedQuery<Categoria> query = manager.createQuery("select l from Categoria l where l.id= " +category, Categoria.class);
		Categoria cat = null;
		
		try { cat = query.getSingleResult(); } catch(PersistenceException e) {manager.getTransaction().rollback(); } finally { manager.close(); }
		return cat;
	}
}
