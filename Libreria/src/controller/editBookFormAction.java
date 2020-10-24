package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import dao.LibroDAO;
import entity.Categoria;
import entity.Libro;
import jpa.CategoriaDAOJPAImpl;
import jpa.LibroDAOJPAImpl;

public class editBookFormAction extends Action
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		Libro libro;
		try {
			List<Categoria> listOfCategories = new CategoriaDAOJPAImpl().getAll();
			libro = new LibroDAOJPAImpl().getById(Integer.parseInt(request.getParameter("isbn")));
			request.setAttribute("listOfCategories", listOfCategories);
			request.setAttribute("libro", libro);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "editBookForm.jsp";
	}

}
