package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LibroDAO;
import databaseH.DataBaseException;
import entity.Libro;
import jpa.LibroDAOJPAImpl;

public class saveBookAction extends Action
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		int author = Integer.parseInt(request.getParameter("author"));
		int category = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		
		new LibroDAOJPAImpl().save(new Libro(isbn, author, category, title));
		return "showBooks.jsp";
	}

}
