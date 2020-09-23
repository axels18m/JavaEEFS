package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateHelper 
{
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	public static SessionFactory buildSessionFactory()
	{
		return new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
