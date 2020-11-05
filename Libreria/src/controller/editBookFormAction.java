package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import dao.LibroDAO;
import entity.Categoria;
import entity.Libro;
import factory.DAOAbstractFactory;
import factory.DAOFactory;
import jpa.CategoriaDAOJPAImpl;
import jpa.LibroDAOJPAImpl;
import service.LibrosImplService;

public class editBookFormAction extends Action
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		Libro libro;
		try {
			LibrosImplService service = new LibrosImplService();
			
			List<Categoria> listOfCategories = service.getAllCategories();
			libro = service.getById(Integer.parseInt(request.getParameter("isbn")));
			request.setAttribute("listOfCategories", listOfCategories);
			request.setAttribute("libro", libro);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "editBookForm.jsp";
	}

}
