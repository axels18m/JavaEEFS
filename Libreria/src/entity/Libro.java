package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// Shift + Alt + S +G -> Setter and getters

@Entity
@Table(name = "Libros")
public class Libro 
{
	/* Start -> hibernate.cfg.xml -> sessionFactory -> session -> transaction -> commit */
	@Id
	private int isbn;
	private int author;
	private int category;
	private String title;
	
	@ManyToOne(optional = false)
	@JoinColumn (name = "category", insertable = false, updatable=false)
	private Categoria cat;
	
	public Libro(int isbn, int aut_lib, int cat_lib, String tit_lib)
	{
		this.isbn = isbn;
		this.author = aut_lib;
		this.category = cat_lib;
		this.title = tit_lib;
	}
	
	public Libro() { super(); }
	
	public Libro(int isbn, int auth_lib, Categoria categoria)
	{
		this.isbn = isbn;
		this.author = auth_lib;
		this.category = categoria.getId();
		this.title = categoria.getDescription();
	}
	
	public Libro(int isbn) { super(); this.isbn = isbn; } 
	
	public int getIsbn() 
	{
		return this.isbn;
	}

	public void setIsbn(int isbn) 
	{
		this.isbn = isbn;
	}

	public int getAuthor() 
	{
		return this.author;
	}

	public void setAuthor(int author) 
	{
		this.author = author;
	}

	public int getCategory() 
	{
		return this.category;
	}

	public void setCategory(int category) 
	{
		this.category = category;
	}

	public String getTitle() 
	{
		return this.title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	@Override
	public boolean equals(Object o)
	{
		int isbn = ((Libro) o).getIsbn();
		return true;
	}
	
	public Categoria getCat()
	{
		return cat;
	}
	
	public void setCat(Categoria Cat)
	{
		this.cat = Cat;
	}
}
