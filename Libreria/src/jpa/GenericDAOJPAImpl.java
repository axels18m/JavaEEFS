package jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import dao.GenericDAO;

public abstract class GenericDAOJPAImpl<T, Id extends Serializable> extends JpaDaoSupport implements GenericDAO<T, Id> 
{
	private Class<T> persistenceClass;
	private JpaTemplate template;
	
	/* We use JpaTemplate only to execute one method. */
	public JpaTemplate getJPATemplate() { return template; }
	
	public void setJPATemplate(JpaTemplate template) { this.template = template; }
	
	
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
		return template.find(persistenceClass, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll()
	{
		return template.find("select l from " + persistenceClass.getSimpleName() + " l");
	}
	
	public void delete(T obj)
	{
		template.remove(template.merge(obj));
	}
	
	public void save(T obj)
	{
		template.merge(obj);
	}
	
	public void insert(T obj)
	{
		template.persist(obj);
	}
}