package dao;

import java.util.List;

import entity.Categoria;
import entity.Libro;

/* LibroDAO and CategoriaDAO are interfaces DAO (Data Access Manager). */
public interface LibroDAO 
{	
	
	public abstract void save(Libro libro);
	public abstract void delete(Libro libro);
	public abstract void insert(Libro libro);
	public abstract List<Libro> getAll();
	/* getById needs to be as "Integer" due to GenericDAO is Serializable, and Serializable must use Clases. So, Integer is a class and we'll use it instead of int. */
	public abstract Libro getById(Integer isbn);
	public abstract List<Libro> getByCategory(Categoria category);
	public abstract List<Libro> getBookByCat(Categoria category);
}
