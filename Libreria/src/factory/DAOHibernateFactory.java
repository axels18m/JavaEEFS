package factory;

import dao.CategoriaDAO;
import dao.CategoriaDAOHibernateImpl;
import dao.LibroDAO;
import dao.LibroDAOHibernateImpl;

public class DAOHibernateFactory implements DAOFactory
{
	public CategoriaDAO getCategoriaDAO() { return new CategoriaDAOHibernateImpl(); }
	
	public LibroDAO getLibroDAO() { return new LibroDAOHibernateImpl(); }
}
