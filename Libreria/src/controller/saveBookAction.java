package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseH.DataBaseException;
import entity.Libro;

public class saveBookAction extends Action
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		int author = Integer.parseInt(request.getParameter("author"));
		int category = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		
		try { new Libro(isbn, author, category, title).save(); } catch (DataBaseException e) { e.printStackTrace(); }
		return "showBooks.jsp";
	}

}
