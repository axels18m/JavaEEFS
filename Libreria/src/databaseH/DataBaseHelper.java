package databaseH;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class DataBaseHelper<T> 
{

	private static final Logger log = Logger.getLogger(DataBaseHelper.class.getPackage().getName());
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String SERVER = "jdbc:mysql://localhost/libreria";
	private static final String USER = "root";
	private static final String PASS = "";
	
	PatternLayout pattern = new PatternLayout("%m %n"); /* %m -> force to print the text, %n -> force to return null */
	FileAppender console = null;
	
	public int editRecord( String query ) throws DataBaseException  
	{
		Connection conn = null;
		Statement state = null;
		int affectedRows = 0;
		
		try { console = new FileAppender(pattern, "logErrors.txt"); } catch (IOException e) { e.printStackTrace(); }
		Logger log = Logger.getLogger("DBLog");
		log.addAppender(console);
		
		try
		{
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(SERVER, USER, PASS);
			state = conn.createStatement();
			affectedRows = state.executeUpdate(query);
			
		} catch(ClassNotFoundException e) {
			log.error("Error de acceso al driver: " + e.getMessage());
			throw new DataBaseException("Error de driver",e);
			
		} catch (SQLException e) {
			log.error("Error de SQL: " + e.getMessage());
			throw new DataBaseException("Error de SQL", e);
		} finally {
			if (state != null)
			{
				try { conn.close(); } catch (SQLException e) {}
			}
			
			if (conn != null)
			{
				try { conn.close(); } catch (SQLException e) {}
			}
		}
		return affectedRows;
	}
	
	private static boolean isNumeric (String chain)
	{
		try {
			Integer.parseInt(chain);
			return true;
			
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	@SuppressWarnings({"finally", "unchecked", "rawtypes"})	
	public List<T> selectRecords(String query, Class className) throws SQLException 
	{
		Connection conn = null;
		Statement statement = null;
		ResultSet rows = null;
		List<T> objectsList = new ArrayList<T>();
		
		try { console = new FileAppender(pattern, "logErrors.txt"); } catch (IOException e) { e.printStackTrace(); }
		Logger log = Logger.getLogger("DBLog");
		log.addAppender(console);
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(SERVER, USER, PASS);
			statement = conn.createStatement();
			rows = statement.executeQuery(query);
			
			while(rows.next())
			{
				T obj = (T) Class.forName(className.getName()).newInstance();
				Method[] methods = obj.getClass().getDeclaredMethods();
				
				for (int i = 0; i < methods.length; i++)
				{
					if (methods[i].getName().startsWith("set")) 
					{
						if (isNumeric(rows.getString(methods[i].getName().substring(3))))
						{
							methods[i].invoke(obj, rows.getInt(methods[i].getName().substring(3)));
						} else {
							methods[i].invoke(obj, rows.getString(methods[i].getName().substring(3)));
						}
					}
					
					if (obj.getClass().getName().equals("java.lang.String")) { obj = (T) rows.getString(1); }
				} 
				objectsList.add(obj);
			}
		} catch (Exception e) {
			log.error("Error al seleccionar registros\n" + e.getMessage());
			System.out.println("Error al seleccionar registros\n" + e.getMessage()+"\n" + e.getCause());
			e.printStackTrace();
			throw new DataBaseException("Error al seleccionar registros\n" + e.getMessage());
			
		} finally {
			if (statement != null) 
			{ 
				statement.close();
			}
			
			if (conn != null)
			{
				conn.close();
			}
			
			return objectsList;
		}
	}
	
	/*
	public List<Libro> getAll()
	{
		TypedQuery<Libro> consult = getManager().createQuery("select l from Libro join fetch l.category", Libro.class);
		return consult.getResultList();
	} */
}