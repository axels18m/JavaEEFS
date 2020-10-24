package dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, Id extends Serializable> 
{
	T getById(Id id);
	List<T> getAll();
	void save(T obj);
	void delete(T obj);
}
