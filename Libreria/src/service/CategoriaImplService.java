package service;

import java.util.List;

import dao.CategoriaDAO;
import entity.Categoria;

public class CategoriaImplService implements CategoriaService
{
	private CategoriaDAO categoriaDAO = null;

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
	public List<Categoria> getAll() 
	{
		return categoriaDAO.getAll();
	}

	@Override
	public Categoria getById(int category) 
	{
		return categoriaDAO.getById(category);
	}

	@Override
	public void save(Categoria category) 
	{
		categoriaDAO.save(category);
	}

	@Override
	public void insert(Categoria category) 
	{
		categoriaDAO.insert(category);	
	}

	@Override
	public void delete(Categoria category) 
	{
		categoriaDAO.delete(category);
	}
}
