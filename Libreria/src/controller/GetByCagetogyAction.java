package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LibroDAO;
import entity.Libro;
import jpa.LibroDAOJPAImpl;

public class GetByCagetogyAction extends Action 
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		List<Libro> listOfBooks = null;
		List<Libro> listOfCategories;
		try {
			listOfCategories = new LibroDAOJPAImpl().getAll();
			if (request.getParameter("category") == null || request.getParameter("category").equals("select")) {
				listOfBooks = new LibroDAOJPAImpl().getAll();
			} else {
				listOfBooks = new LibroDAOJPAImpl().getByCategory(Integer.parseInt(request.getParameter("category")));
			}
			
			request.setAttribute("listOfBooks", listOfBooks);
			request.setAttribute("listOfCategories", listOfCategories);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "showBooks.jsp";
	}
}
