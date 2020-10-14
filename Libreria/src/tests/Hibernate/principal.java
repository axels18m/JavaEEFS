package tests.Hibernate;

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

import entity.Libro;
import hibernate.hibernateHelper;

public class principal 
{
	public static void main(String[] args)
	{
		principal p = new principal();
		//p.insert();
		//p.select();
		//p.TestJoins();
		p.TestJpa();
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
		TypedQuery<Libro> query = managerE.createQuery("select libro from Libro libro", Libro.class);
		List<Libro> listOfBooks = query.getResultList();
		for(Libro libro : listOfBooks)
		{
			System.out.println(libro.getTitle());
		}
	}
}
