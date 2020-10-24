package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceException;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.hibernateHelper;
import jpa.JPAHelper;

@Entity
@Table(name = "Categorias")
public class Categoria 
{
	
	@Id
	private int id;
	private String description;
	
	@OneToMany
	@JoinColumn(name="category", insertable = false, updatable=false)
	private List<Libro> listOfBooks;
	
	
	public Categoria(int id, String desc)
	{
		this.id = id;
		this.description = desc;
	}
	
	public Categoria() { };

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}
	
}
