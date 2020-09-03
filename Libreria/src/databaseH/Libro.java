package databaseH;

import java.util.List;

// Shift + Alt + S +G -> Setter and getters
public class Libro 
{
	private String isbn;
	String auth_lib, cat_lib, tit_lib;
	
	public Libro(String isbn, String aut_lib, String cat_lib, String tit_lib)
	{
		this.isbn = isbn;
		this.auth_lib = aut_lib;
		this.cat_lib = cat_lib;
		this.tit_lib = tit_lib;
	}
	
	public void save()
	{
		String query = "UPDATE Libros set author = " + this.auth_lib + ", category = " + this.cat_lib + ", " + 
						", title = " + this.tit_lib + " WHERE isbn = " + Integer.parseInt(isbn);
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		helper.editRecord(query);
	}
	
	public void insert()
	{
		String query = "INSERT INTO Libros(isbn, author, category, title) VALUES";
		query += "(" + this.auth_lib + ", category = " + this.cat_lib + ", " + ", title = " + this.tit_lib +")";
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		helper.editRecord(query);
	}

	public void delete ()
	{
		String query = "DELETE FROM Libros WHERE isbn = " + this.isbn;
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		helper.editRecord(query);
	}
	
	public static List<Libro> gettByCategory( String category)
	{
		String query = "SELECT isbn, author, category, title FROM Libros WHERE category = '" + category +"'";
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		List<Libro>listOfBooks = helper.getRecords(query, Libro.class);
		return listOfBooks;
	}
	
	public static List<String> getAllCategories()
	{
		String query = "SELECT DISTINC(category) AS cat FROM Libros";
		DataBaseHelper<String> helper = new DataBaseHelper<String>();
		List<String> listOfCat = helper.getRecords(query, String.class);
		return listOfCat;
	}
	
	public static List<Libro> getAll()
	{
		String query = "SELECT isbn, author, category, title FROM Libros";
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		List<Libro> listOfBooks = helper.getRecords(query, Libro.class);
		return listOfBooks;
	}
	
	public static Libro getById(String isbn)
	{
		String query = "SELECT isbn, author, category,title FROM Libros WHERE isbn = '" + isbn +"'";
		DataBaseHelper<String> helper = new DataBaseHelper<String>();
		List<String> listOfBooks = helper.getRecords(query, Libro.class);
		return (Libro) listOfBooks;
	}
	
	public void findById(String Id)
	{
		// Cast id -> int
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuth_lib() {
		return auth_lib;
	}

	public void setAuth_lib(String auth_lib) {
		this.auth_lib = auth_lib;
	}

	public String getCat_lib() {
		return cat_lib;
	}

	public void setCat_lib(String cat_lib) {
		this.cat_lib = cat_lib;
	}

	public String getTit_lib() {
		return tit_lib;
	}

	public void setTit_lib(String tit_lib) {
		this.tit_lib = tit_lib;
	}
}
