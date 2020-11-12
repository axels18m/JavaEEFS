package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.CategoriaDAO;
import dao.LibroDAO;
import entity.Libro;

public class LibrosImplService implements LibrosService
{
	private LibroDAO libroDAO = null;
	private CategoriaDAO categoriaDAO = null;

	@Transactional
	public void save(Libro libro) 
	{
		libroDAO.save(libro);	
	}

	@Transactional
	public void delete(Libro libro) 
	{
		libroDAO.delete(libro);	
	}

	@Transactional
	public List<Libro> getAll() 
	{
		return libroDAO.getAll();
	}

	@Transactional
	public Libro getById(int isbn) 
	{
		return libroDAO.getById(isbn);
	}

	@Transactional
	public List<Libro> getByCategory(int id) 
	{
		return libroDAO.getByCategory(id);
	}

	@Transactional
	public LibroDAO getLibroDAO() 
	{
		return libroDAO;
	}

	@Transactional
	public void setLibroDAO(LibroDAO libroDAO) 
	{
		this.libroDAO = libroDAO;
	}

	@Transactional
	public CategoriaDAO getCategoriaDAO() 
	{
		return categoriaDAO;
	}

	@Transactional
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) 
	{
		this.categoriaDAO = categoriaDAO;
	}

	@Transactional
	public void insert(Libro libro) 
	{
		libroDAO.insert(libro);
	}
}
