package service;

import java.util.List;

import dao.CategoriaDAO;
import entity.Categoria;

public interface CategoriaService 
{
	public CategoriaDAO getCategoriaDAO();
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);
	
	public List<Categoria> getAll();
	public Categoria getById(int category);
	
	public void save(Categoria category);
	public void insert(Categoria category);
	public void delete(Categoria category);
}
