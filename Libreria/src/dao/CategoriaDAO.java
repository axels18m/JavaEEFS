package dao;

import java.util.List;
import entity.Categoria;

public interface CategoriaDAO 
{
	public abstract List<Categoria> getAll();
	public abstract Categoria getById(int category);
}
