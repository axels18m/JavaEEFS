package tests.Hibernate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entity.Categoria;
import entity.Libro;
import hibernate.hibernateHelper;

public class principal 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		principal p = new principal();
		//p.insert();
		//p.select();
		//p.TestJoins();
		///p.TestJpa();
		p.testJPA();
	}
	
	private void insert()
	{
		/* Start -> hibernate.cfg.xml -> sessionFactory -> session -> transaction -> commit */
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(new Libro(2, 0, 0, "TestHibernate"));
			transaction.commit();
		
		} catch (HibernateException e) {
			System.out.println(e.getMessage() +","+e.getCause());
			e.printStackTrace();
			transaction.rollback();
		
		} finally {
			session.close();
		}
	}
	
	private void select()
	{
		Session session = null;
		try {
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			Query query = session.createQuery("from Libro libro");
			List<Libro> lista = query.list();
			for (Libro l: lista)
			{
				System.out.println(l.getIsbn());
			}
		
		} catch (HibernateException e) {
			System.out.println(e.getMessage() +","+e.getCause());

		} finally {
			session.close();
		}
	}
	
	public void TestJoins()
	{
		SessionFactory factory = hibernateHelper.getSessionFactory();
		Session session = factory.openSession();
		List<Libro> listOfBooks = session.createQuery("from Libro libro").list();
		for(Libro libro : listOfBooks)
		{
			System.out.println(libro.getCategory());
			System.out.println(libro.getCat().getDescription());
		}
		session.close();
	}
	
	public void TestJpa()
	{
		EntityManagerFactory managerFac = Persistence.createEntityManagerFactory("LibreriaJava");
		
		/* EntityManager	->	Manage the life cycle of the entities and is able to save objects in our DB as select them through queries. */
		EntityManager managerE = managerFac.createEntityManager();
		/* Query -> Class Libro -> DB Libro Table */
		TypedQuery<Libro> query = managerE.createQuery("select libro from Libro libro", Libro.class);
		List<Libro> listOfBooks = query.getResultList();
		for(Libro libro : listOfBooks)
		{
			System.out.println(libro.getTitle());
		}
	}
	
	public void testJPA() throws NumberFormatException, IOException
	{
		String txt = "";
		Reader reader = new FileReader("libros.txt");
		BufferedReader bufferedR = new BufferedReader(reader);
		List<Libro> listOfBooks = new ArrayList<Libro>();
		Libro book = null;
		Categoria category = null;
		
		while ((txt = bufferedR.readLine()) != null)
		{
			String data[] = txt.split(",");
			category = new Categoria(Integer.parseInt(data[2]), data[3]);
			book = new Libro(Integer.parseInt(data[0]), Integer.parseInt(data[1]), category);
			listOfBooks.add(book);
		}
		
		for (Libro l : listOfBooks)
		{
			System.out.println(l.getTitle());
		}
	}
}
