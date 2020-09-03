package databaseH;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper<T> 
{
	
	private static final String DRIVER = "com.mysql.jdbcDriver";
	private static final String SERVER = "jdbc:mysql://localhost/libreria";
	private static final String USER = "root";
	private static final String PASS = "";
	
	public int editRecord( String query )
	{
		Connection conn = null;
		Statement state = null;
		int affectedRows = 0;
		
		try
		{
			conn = DriverManager.getConnection(SERVER, USER, PASS);
			state = conn.createStatement();
			affectedRows = state.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
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
	public List<T> getRecords(String query, Class className)
	{
		Connection conn = null;
		Statement statement = null;
		ResultSet rows = null;
		List<T> objectsList = new ArrayList<T>();
		
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
					if (isNumeric(rows.getNString(methods[i].getName().substring(3))))
					{
						methods[i].invoke(obj, rows.getInt(methods[i].getName().substring(3)));
					} else {
						methods[i].invoke(obj, rows.getString(methods[i].getName().substring(3)));
					}
				}
				
				if (obj.getClass().getName().equals("java.lang.String"))
				{
					obj = (T) rows.getString(1); 
				}
			}
		} catch (Exception e) {
			System.out.println("Error al seleccionar registros");
			
		} finally {
			if (statement != null) 
			{ 
				try { statement.close(); } catch (SQLException e) { }
			}
			
			if (conn != null)
			{
				try { conn.close(); } catch (SQLException e) { }
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