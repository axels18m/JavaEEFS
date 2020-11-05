package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import dao.LibroDAO;
import databaseH.DataBaseException;
import entity.Categoria;
import entity.Libro;
import factory.DAOAbstractFactory;
import factory.DAOFactory;
import jpa.CategoriaDAOJPAImpl;
import service.LibrosImplService;

public class insertBookFormAction extends Action
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
	{
		LibrosImplService service = new LibrosImplService();
		List<Categoria> listOfCategories = service.getAllCategories();
		request.setAttribute("listOfCategories", listOfCategories);
		return "insertBookForm.jsp";
	}
}
