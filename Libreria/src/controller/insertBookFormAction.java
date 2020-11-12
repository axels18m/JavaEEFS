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
import service.CategoriaService;
import service.LibrosImplService;
import service.LibrosService;

public class insertBookFormAction extends Action
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
	{
		List<Categoria> listOfCategories = ((CategoriaService) getBean("servicioCategorias", request)).getAll();
		request.setAttribute("listOfCategories", listOfCategories);
		return "insertBookForm.jsp";
	}
}
