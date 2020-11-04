package factory;

import java.util.Properties;

import tests.Hibernate.principal;

public abstract class DAOAbstractFactory 
{
	public static DAOFactory getInstance()
	{
		String impl = getImpl();
		if (impl.equals("hibernate")) { return new DAOHibernateFactory(); } else { return new DAOJPAFactory(); }
	}
	
	public static String getImpl()
	{
		Properties properties = new Properties();
		String type = null;
		
		try 
		{
			/* Load the file where the file path is */
			properties.load(principal.class.getResourceAsStream("settings.properties")); 
			type = properties.getProperty("persistence");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return type;
	}
}
