package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import databaseH.DataBaseException;
import entity.Categoria;
import entity.Libro;
import jpa.CategoriaDAOJPAImpl;

public class insertBookFormAction extends Action
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
	{
		List<Categoria> listOfCategories = new CategoriaDAOJPAImpl().getAll();
		request.setAttribute("listOfCategories", listOfCategories);
		return "insertBookForm.jsp";
	}
}
