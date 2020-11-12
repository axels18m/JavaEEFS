package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.CategoriaDAO;
import entity.Categoria;

public class CategoriaImplService implements CategoriaService
{
	private CategoriaDAO categoriaDAO = null;

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
	public List<Categoria> getAll() 
	{
		return categoriaDAO.getAll();
	}

	@Transactional
	public Categoria getById(int category) 
	{
		return categoriaDAO.getById(category);
	}

	@Transactional
	public void save(Categoria category) 
	{
		categoriaDAO.save(category);
	}

	@Transactional
	public void insert(Categoria category) 
	{
		categoriaDAO.insert(category);	
	}

	@Transactional
	public void delete(Categoria category) 
	{
		categoriaDAO.delete(category);
	}
}
