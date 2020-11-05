package service;

import java.util.List;

import entity.Categoria;
import entity.Libro;

public interface LibrosService 
{
	public void save(Libro libro);
	public void delete(Libro libro);
	public List<Libro> getAll();
	public List<Categoria> getAllCategories();
	public Libro getById(int isbn);
	public Categoria getByCatById(int id);
	public List<Libro> getByCategory(int id);
}
