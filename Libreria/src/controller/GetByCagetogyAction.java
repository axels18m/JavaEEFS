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
		List<Libro> listOfBookss = null;
		List<String> listOfCategories;
		try {
			listOfCategories = Libro.getAllCategories();
			if (request.getParameter("category") == null || request.getParameter("category").equals("select")) {
				listOfBookss = Libro.getAll();
			} else {
				listOfBookss = Libro.getByCategory(request.getParameter("category"));
			}
			
			request.setAttribute("listOfBooks", listOfBookss);
			request.setAttribute("listOfCategories", listOfCategories);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "showBooks.jsp";
	}
}
