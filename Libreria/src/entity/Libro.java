package entity;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import databaseH.DataBaseException;
import databaseH.DataBaseHelper;
import hibernate.hibernateHelper;

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
		SessionFactory factory = hibernateHelper.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(this);
		session.getTransaction().commit();
	}
	
	public void insert() throws DataBaseException  
	{
		SessionFactory factory = hibernateHelper.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(this);
		session.getTransaction().commit();
	}

	public void delete () throws DataBaseException
	{
		SessionFactory factory = hibernateHelper.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.delete(this);
		session.getTransaction().commit();
	}
	
	@SuppressWarnings({ "unchecked" })
	public static List<Libro> getByCategory(int category) throws SQLException
	{
		SessionFactory factory = hibernateHelper.getSessionFactory();
		Session session = factory.openSession();
		Query<Libro> query = session.createQuery(" from Libro libro where libro.category="+category);
		//query.setInteger("category", category);
		List<Libro> listOfBooks = query.list();
		session.close();
		return listOfBooks;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Libro> getAllCategories() throws SQLException
	{
		SessionFactory factory = hibernateHelper.getSessionFactory();
		Session session = factory.openSession();
		List<Libro> listOfCategories = session.createQuery(" select distinct libro.category from Libro libro").list();
		session.close();
		return listOfCategories;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Libro> getAll() throws SQLException
	{
		SessionFactory factory = hibernateHelper.getSessionFactory();
		Session session = factory.openSession();
		List<Libro> listOfBooks = session.createQuery("from Libro libro right join fetch libro.cat").list();
		session.close();
		return listOfBooks;
	}
	
	public static Libro getById(int isbn) throws SQLException
	{
		SessionFactory factory = hibernateHelper.getSessionFactory();
		Session session = factory.openSession();
		Libro libro = session.get(Libro.class, isbn);
		session.close();
		return libro;
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
