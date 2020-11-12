package jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import dao.GenericDAO;

public abstract class GenericDAOJPAImpl<T, Id extends Serializable> extends JpaDaoSupport implements GenericDAO<T, Id> 
{
	private Class<T> persistenceClass;
	
	@SuppressWarnings("unchecked")
	public GenericDAOJPAImpl()
	{
		/* Reflection
		 * ParameterizedType represents a parameterized type such as Collection<String>. Is created the first time it's needed by a reflective method
		 * getActualTypeArguments returns an array of Type objects representing the actual type arguments to this type. */
		this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public T getById(Id id)
	{
		return getJpaTemplate().find(persistenceClass, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> getAll()
	{
		return getJpaTemplate().find("select l from " + persistenceClass.getSimpleName() + " l");
	}
	
	@Transactional
	public void delete(T obj)
	{
		getJpaTemplate().remove(getJpaTemplate().merge(obj));
	}
	
	@Transactional
	public void save(T obj)
	{
		getJpaTemplate().merge(obj);
	}
	
	@Transactional
	public void insert(T obj)
	{
		getJpaTemplate().persist(obj);
	}
}