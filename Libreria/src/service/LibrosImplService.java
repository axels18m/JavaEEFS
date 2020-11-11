package service;

import java.util.List;

import dao.CategoriaDAO;
import dao.LibroDAO;
import entity.Categoria;
import entity.Libro;

public class LibrosImplService implements LibrosService
{
	private LibroDAO libroDAO = null;
	private CategoriaDAO categoriaDAO = null;
	
	/*
	public LibrosImplService()
	{
		//Deprecated due to all dependencies could be asign through setters and getters  
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		libroDAO = (LibroDAO) factory.getBean("libroDAO");
		categoriaDAO = (CategoriaDAO) factory.getBean("categoriaDAO");
	}*/

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
	public List<Libro> getByCategory(int id) 
	{
		return libroDAO.getBookByCat(id);
	}

	@Override
	public LibroDAO getLibroDAO() 
	{
		return libroDAO;
	}

	@Override
	public void setLibroDAO(LibroDAO libroDAO) 
	{
		this.libroDAO = libroDAO;
	}

	@Override
	public CategoriaDAO getCategoriaDAO() 
	{
		return categoriaDAO;
	}

	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) 
	{
		this.categoriaDAO = categoriaDAO;
	}

	@Override
	public void insert(Libro libro) 
	{
		libroDAO.insert(libro);
	}
	
	
}
