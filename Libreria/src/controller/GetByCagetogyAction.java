package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Libro;

public class GetByCagetogyAction extends Action 
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		List<Libro> listOfBooks = null;
		List<Libro> listOfCategories;
		try {
			listOfCategories = Libro.getAllCategories();
			if (request.getParameter("category") == null || request.getParameter("category").equals("select")) {
				listOfBooks = Libro.getAll();
			} else {
				listOfBooks = Libro.getByCategory(Integer.parseInt(request.getParameter("category")));
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
