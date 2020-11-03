package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Libro;
import jpa.LibroDAOJPAImpl;

public class GetByCagetogyAction extends Action 
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		List<Libro> listOfBooks = null;
		List<Libro> listOfCategories;
		listOfCategories = new LibroDAOJPAImpl().getAll();
		if (request.getParameter("category") == null || request.getParameter("category").equals("select")) {
			listOfBooks = new LibroDAOJPAImpl().getAll();
		} else {
			listOfBooks = new LibroDAOJPAImpl().getByCategory(Integer.parseInt(request.getParameter("category")));
		}
		
		request.setAttribute("listOfBooks", listOfBooks);
		request.setAttribute("listOfCategories", listOfCategories);
		
		return "showBooks.jsp";
	}
}
