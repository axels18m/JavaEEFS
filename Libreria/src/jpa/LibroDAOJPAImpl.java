package jpa;
/* JPA are implementatios of persistency. */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import dao.CategoriaDAO;
import dao.LibroDAO;
import entity.Categoria;
import entity.Libro;

public class LibroDAOJPAImpl extends GenericDAOJPAImpl<Libro, Integer> implements LibroDAO
{

	public List<Libro> getByCategory(int category)
	{
		EntityManagerFactory factorySession = JPAHelper.getJPAFactory();
		EntityManager manager = factorySession.createEntityManager();
		
		CategoriaDAO catDao = new CategoriaDAOJPAImpl();
		TypedQuery<Libro> query = manager.createQuery("select l from Libro l where l.category= " +category, Libro.class);
		List<Libro> listOfBooks = null;
		
		try { listOfBooks = query.getResultList(); } catch(PersistenceException e) {manager.getTransaction().rollback(); } finally { manager.close(); }
		return listOfBooks;
	}

	@Override
	public List<Libro> getBookByCat(Categoria category) 
	{
		EntityManagerFactory factorySession = JPAHelper.getJPAFactory();
		EntityManager manager = factorySession.createEntityManager();
		
		CategoriaDAO catDao = new CategoriaDAOJPAImpl();
		TypedQuery<Libro> query = manager.createQuery("select l from Libro l where l.category= " +category.getId(), Libro.class);
		List<Libro> listOfBooks = null;
		
		try { listOfBooks = query.getResultList(); } catch(PersistenceException e) {manager.getTransaction().rollback(); } finally { manager.close(); }
		return listOfBooks;
	}
}
