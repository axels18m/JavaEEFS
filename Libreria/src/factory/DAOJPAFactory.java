package factory;

import dao.CategoriaDAO;
import dao.LibroDAO;
import jpa.CategoriaDAOJPAImpl;
import jpa.LibroDAOJPAImpl;

public class DAOJPAFactory implements DAOFactory
{
	public CategoriaDAO getCategoriaDAO() { return new CategoriaDAOJPAImpl(); }
	
	public LibroDAO getLibroDAO() { return new LibroDAOJPAImpl(); }
}
