package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseH.DataBaseException;
import entity.Libro;


public class librosController extends HttpServlet
{
	int isbn;
	int author;
	int category;
	String title;

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/* Provides the facility of dispatching the request to another resource (jsp, servlet, html, etc). */
		RequestDispatcher dispatcher = null;
		
		List<Libro> listOfBooks;
		try {
			if (request.getServletPath().contentEquals("/showBooks.do"))
			{
				listOfBooks = Libro.getAll();
				List<String> listOfCategories = Libro.getAllCategories();
				request.setAttribute("listOfBooks", listOfBooks);
				request.setAttribute("listOfCategories", listOfCategories);
				
				dispatcher = request.getRequestDispatcher("showBooks.jsp");
				
			} else if (request.getServletPath().equals("/insertBookForm.do")) {
				setNewLibro(request);
				new Libro(this.isbn, this.author, this.category, this.title).insert();
				dispatcher = request.getRequestDispatcher("showBooks.jsp");
			
			} else if (request.getServletPath().equals("/deleteBook.do")){
				new Libro(Integer.parseInt(request.getParameter("isbn"))).delete();
				dispatcher = request.getRequestDispatcher("showBooks.do");
			
			} else if (request.getServletPath().equals("/saveBook.do")) {
				setNewLibro(request);
				new Libro(this.isbn, this.author, this.category, this.title).save();
				dispatcher = request.getRequestDispatcher("showBooks.jsp");
				
			} else if (request.getServletPath().equals("/editForm.do")) {
				List<String> listOfCategories = Libro.getAllCategories();
				Libro libro = Libro.getById(Integer.parseInt(request.getParameter("isbn")));
				request.setAttribute("listOfCategories#", listOfCategories);
				request.setAttribute("libro", libro);
				dispatcher = request.getRequestDispatcher("editForm.jsp");
			
			} else {
				List<Libro> listOfBookss = null;
				List<String> listOfCategories = Libro.getAllCategories();
				
				if (request.getParameter("category") == null || request.getParameter("category").equals("select")) {
					listOfBookss = Libro.getAll();
				} else {
					listOfBookss = Libro.getByCategory(request.getParameter("category"));
				}
				
				request.setAttribute("listOfBooks", listOfBookss);
				request.setAttribute("listOfCategories", listOfCategories);
				dispatcher = request.getRequestDispatcher("showBooks.jsp");
			}
			dispatcher.forward(request, response);
			
		} catch (SQLException | DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setNewLibro(HttpServletRequest request)
	{
		this.isbn = Integer.parseInt(request.getParameter("isbn"));
		this.author = Integer.parseInt(request.getParameter("author"));
		this.category = Integer.parseInt(request.getParameter("category"));
		this.title = request.getParameter("title");
	}
}
