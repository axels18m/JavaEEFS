package entity;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
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
	@Id
	private int isbn;
	private int auth_lib;
	private int cat_lib;
	private String tit_lib;
	
	public Libro(int isbn, int aut_lib, int cat_lib, String tit_lib)
	{
		this.isbn = isbn;
		this.auth_lib = aut_lib;
		this.cat_lib = cat_lib;
		this.tit_lib = tit_lib;
	}
	
	public Libro() { super(); }
	
	public Libro(int isbn) { super(); this.isbn = isbn; } 
	
	public int getIsbn() {
		return this.isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getAuth_lib() {
		return this.auth_lib;
	}

	public void setAuth_lib(int auth_lib) {
		this.auth_lib = auth_lib;
	}

	public int getCat_lib() {
		return this.cat_lib;
	}

	public void setCat_lib(int cat_lib) {
		this.cat_lib = cat_lib;
	}

	public String getTit_lib() {
		return this.tit_lib;
	}

	public void setTit_lib(String tit_lib) {
		this.tit_lib = tit_lib;
	}
	
	public void save() throws DataBaseException
	{
		SessionFactory factory = hibernateHelper.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(this);
		session.getTransaction().commit();
	}
	
	public void insert() throws DataBaseException  
	{
		SessionFactory factory = hibernateHelper.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(this);
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
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<Libro> getByCategory(String category) throws SQLException
	{
		SessionFactory factory = hibernateHelper.getSessionFactory();
		Session session = factory.openSession();
		Query query = session.createQuery("from Libro libro where libro.category=:category");
		query.setString("category", category);
		List<Libro> listOfBooks = query.list();
		session.close();
		return listOfBooks;
	}
	
	public static List<Libro> getAllCategories() throws SQLException
	{
		SessionFactory factory = hibernateHelper.getSessionFactory();
		Session session = factory.openSession();
		List<Libro> listOfCategories = session.createQuery("select distinct libro.category from Libro libro").list();
		session.close();
		return listOfCategories;
	}
	
	public static List<Libro> getAll() throws SQLException
	{
		SessionFactory factory = hibernateHelper.getSessionFactory();
		Session session = factory.openSession();
		List<Libro> listOfCategories = session.createQuery("from Libro libro").list();
		session.close();
		return listOfCategories;
	}
	
	public static Libro getById(int isbn) throws SQLException
	{
		SessionFactory factory = hibernateHelper.getSessionFactory();
		Session session = factory.openSession();
		Libro libro = (Libro) session.get(Libro.class,isbn);
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
}
