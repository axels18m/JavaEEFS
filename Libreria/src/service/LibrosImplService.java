package service;

import java.util.List;

import dao.CategoriaDAO;
import dao.LibroDAO;
import entity.Categoria;
import entity.Libro;
import factory.DAOAbstractFactory;
import factory.DAOFactory;

public class LibrosImplService implements LibrosService
{
	private LibroDAO libroDAO = null;
	private CategoriaDAO categoriaDAO = null;
	
	public LibrosImplService()
	{
		DAOFactory factory = DAOAbstractFactory.getInstance();
		libroDAO = factory.getLibroDAO();
		categoriaDAO = factory.getCategoriaDAO();
	}

	@Override
	public void save(Libro libro) 
	{
		libroDAO.save(libro);	
	}

	@Override
	public void delete(Libro libro) 
	{
		libroDAO.delete(libro);	
	}

	@Override
	public List<Libro> getAll() 
	{
		return libroDAO.getAll();
	}

	@Override
	public List<Categoria> getAllCategories() 
	{
		return categoriaDAO.getAll();
	}

	@Override
	public Libro getById(int isbn) 
	{
		return libroDAO.getById(isbn);
	}

	@Override
	public Categoria getByCatById(int id) 
	{
		return categoriaDAO.getById(id);
	}

	@Override
	public List<Libro> getByCategory(int id) 
	{
		return libroDAO.getBookByCat(id);
	}
	
	
}
