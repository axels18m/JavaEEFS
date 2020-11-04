package factory;

import dao.CategoriaDAO;
import dao.LibroDAO;

public interface DAOFactory 
{
	public CategoriaDAO getCategoriaDAO();
	
	public LibroDAO getLibroDAO();
}
