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
import service.CategoriaService;
import service.LibrosImplService;
import service.LibrosService;

public class editBookFormAction extends Action
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			List<Categoria> listOfCategories = ((CategoriaService) getBean("servicioCategorias", request)).getAll();
			Libro libro = ((LibrosService) getBean("servicioLibros", request)).getById(Integer.parseInt(request.getParameter("isbn")));
			request.setAttribute("listOfCategories", listOfCategories);
			request.setAttribute("libro", libro);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "editBookForm.jsp";
	}

}
