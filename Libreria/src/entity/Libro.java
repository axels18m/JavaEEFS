package entity;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import databaseH.DataBaseException;
import databaseH.DataBaseHelper;

// Shift + Alt + S +G -> Setter and getters

@Entity
@Table(name="Libros")
public class Libro 
{
	private int isbn;
	int auth_lib;
	int cat_lib;
	String tit_lib;
	
	public Libro(int isbn, int aut_lib, int cat_lib, String tit_lib)
	{
		this.isbn = isbn;
		this.auth_lib = aut_lib;
		this.cat_lib = cat_lib;
		this.tit_lib = tit_lib;
	}
	
	public Libro() { super(); }
	
	public Libro(int isbn) { super(); this.isbn = isbn; } 
	
	public int getIsbn() {
		return this.isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getAuth_lib() {
		return this.auth_lib;
	}

	public void setAuthor(int auth_lib) {
		this.auth_lib = auth_lib;
	}

	public int getCat_lib() {
		return this.cat_lib;
	}

	public void setCategory(int cat_lib) {
		this.cat_lib = cat_lib;
	}

	public String getTit_lib() {
		return this.tit_lib;
	}

	public void setTitle(String tit_lib) {
		this.tit_lib = tit_lib;
	}
	
	public void save() throws DataBaseException
	{
		String query = "UPDATE Libros set author = " + this.auth_lib + ", category = " + this.cat_lib + ", title = '" + this.tit_lib + "' WHERE isbn = " + this.isbn;
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		helper.editRecord(query);
	}
	
	public void insert() throws DataBaseException  
	{
		String query = "INSERT INTO Libros(isbn, author, category, title) VALUES";
		query += "("  + this.isbn + ", " + this.auth_lib + ", " + this.cat_lib + ", '" + this.tit_lib +"')";
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		helper.editRecord(query);
	}

	public void delete () throws DataBaseException
	{
		String query = "DELETE FROM Libros WHERE isbn = " + this.isbn;
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		helper.editRecord(query);
	}
	
	public static List<Libro> getByCategory(String category) throws SQLException
	{
		String query = "SELECT * FROM Libros WHERE category = " + category;
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		List<Libro> listOfBooks = helper.selectRecords(query, Libro.class);
		return listOfBooks;
	}
	
	public static List<String> getAllCategories() throws SQLException
	{
		String query = "SELECT DISTINCT(category) FROM Libros";
		DataBaseHelper<String> helper = new DataBaseHelper<String>();
		List<String> listOfCat = helper.selectRecords(query, String.class);
		return listOfCat;
	}
	
	public static List<Libro> getAll() throws SQLException
	{
		String query = "SELECT isbn, author, category, title FROM Libros";
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		List<Libro> listOfBooks = helper.selectRecords(query, Libro.class);
		return listOfBooks;
	}
	
	public static Libro getById(int isbn) throws SQLException
	{
		String query = "SELECT isbn, author, category, title FROM Libros WHERE isbn = " + isbn;
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		List<Libro> listOfBooks = helper.selectRecords(query, Libro.class);
		return listOfBooks.get(0);
	}
	
	/*
	@Override
	public int hashCode() { return isbn.hashCode(); }
	
	@Override
	public boolean equals(Object o)
	{
		int isbn = ((Libro) o).getIsbn();
		return isbn.equals(isbn);
	}*/
}
