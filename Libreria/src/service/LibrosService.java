package service;

import java.util.List;

import dao.CategoriaDAO;
import dao.LibroDAO;
import entity.Libro;

public interface LibrosService 
{
	public LibroDAO getLibroDAO();
	public void setLibroDAO(LibroDAO libroDAO);
	public CategoriaDAO getCategoriaDAO();
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);
	
	
	public void save(Libro libro);
	public void insert(Libro libro);
	public void delete(Libro libro);
	public List<Libro> getAll();
	public Libro getById(int isbn);
	public List<Libro> getByCategory(int id);
}
