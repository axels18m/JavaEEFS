package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Libro;

public class editBookFormAction extends Action
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		Libro libro;
		try {
			List<String> listOfCategories = Libro.getAllCategories();
			libro = Libro.getById(Integer.parseInt(request.getParameter("isbn")));
			request.setAttribute("listOfCategories#", listOfCategories);
			request.setAttribute("libro", libro);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "editBookForm.jsp";
	}

}
