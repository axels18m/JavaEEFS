package entity;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceException;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import databaseH.DataBaseException;
import databaseH.DataBaseHelper;
import hibernate.hibernateHelper;
import jpa.JPAHelper;

// Shift + Alt + S +G -> Setter and getters

@Entity
@Table(name = "Libros")
public class Libro 
{
	/* Start -> hibernate.cfg.xml -> sessionFactory -> session -> transaction -> commit */
	@Id
	private int isbn;
	private int author;
	private int category;
	private String title;
	
	@ManyToOne(optional = false)
	@JoinColumn (name = "category", insertable = false, updatable=false)
	private Categoria cat;
	
	public Libro(int isbn, int aut_lib, int cat_lib, String tit_lib)
	{
		this.isbn = isbn;
		this.author = aut_lib;
		this.category = cat_lib;
		this.title = tit_lib;
	}
	
	public Libro() { super(); }
	
	public Libro(int isbn, int auth_lib, Categoria categoria)
	{
		this.isbn = isbn;
		this.author = auth_lib;
		this.cat = categoria;
	}
	
	public Libro(int isbn) { super(); this.isbn = isbn; } 
	
	public int getIsbn() {
		return this.isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getAuthor() {
		return this.author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getCategory() {
		return this.category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void save() throws DataBaseException
	{
		EntityManager manager = jpa();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.merge(this);
			transaction.commit();
		} catch(PersistenceException e) {
			/* Roll back (revierte) the current resource transaction. */
			manager.getTransaction().rollback();
			
		} finally {
			manager.close();
				
		}
	}
	
	public void insert() throws DataBaseException  
	{
		EntityManager manager = jpa();
		
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(this);
			transaction.commit();
		} catch(PersistenceException e) {
			/* Roll back (revierte) the current resource transaction. */
			manager.getTransaction().rollback();
			
		} finally {
			manager.close();
				
		}
	}

	public void delete () throws DataBaseException
	{
		EntityManager manager = jpa();
		
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(manager.merge(this));
			transaction.commit();
		} catch(PersistenceException e) {
			/* Roll back (revierte) the current resource transaction. */
			manager.getTransaction().rollback();
			
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

	public static List<Libro> getByCategory(int category) throws SQLException
	{
		EntityManager manager = jpa();
		TypedQuery<Libro> query = manager.createQuery("from Libro libro where libro.category= " +category, Libro.class);
		List<Libro> listOfBooks = null;
		
		try { listOfBooks = query.getResultList(); } catch(PersistenceException e) {manager.getTransaction().rollback(); } finally { manager.close(); }
		return listOfBooks;
	}
	
	public static List<Libro> getAllCategories() throws SQLException
	{
		EntityManager manager = jpa();
		TypedQuery<Libro> query = manager.createQuery("select distinct libro.category from Libro libro", Libro.class);
		List<Libro> listOfCategories = null;
		
		try { listOfCategories = query.getResultList(); } catch(PersistenceException e) {manager.getTransaction().rollback(); } finally { manager.close(); }
		return listOfCategories;
	}
	
	public static List<Libro> getAll() throws SQLException
	{
		EntityManager manager = jpa();
		TypedQuery<Libro> query = manager.createQuery("from Libro libro right join fetch libro.cat", Libro.class);
		List<Libro> listOfBooks = null;
		
		try { listOfBooks = query.getResultList(); } catch(PersistenceException e) {manager.getTransaction().rollback(); } finally { manager.close(); }
		return listOfBooks;
	}
	
	public static Libro getById(int isbn) throws SQLException
	{
		EntityManager manager = jpa();
		TypedQuery<Libro> query = manager.createQuery("select libro from Libro libro join fetch libro.cat where libro.isbn =" + isbn, Libro.class);
		Libro book = null;
		
		try { book = query.getSingleResult(); } catch(PersistenceException e) {manager.getTransaction().rollback(); } finally { manager.close(); }
		return book;
	}
	
	
	//@Override
	//public int hashCode() { return isbn.hashCode(); }
	
	@Override
	public boolean equals(Object o)
	{
		int isbn = ((Libro) o).getIsbn();
		return true;
	}
	
	public Categoria getCat()
	{
		return cat;
	}
	
	public void setCat(Categoria Cat)
	{
		this.cat = Cat;
	}
}
