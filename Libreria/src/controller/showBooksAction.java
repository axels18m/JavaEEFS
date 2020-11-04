package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import dao.LibroDAO;
import entity.Categoria;
import entity.Libro;
import factory.DAOAbstractFactory;
import factory.DAOFactory;

public class showBooksAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		/* Building the different types of objects inside the persistence layer. */
		DAOFactory factory = DAOAbstractFactory.getInstance();
		LibroDAO libroDAO = factory.getLibroDAO();
		CategoriaDAO categoriaDAO = factory.getCategoriaDAO();
		
		List<Libro> listOfBooks = libroDAO.getAll();
		List<Categoria> listOfCategories = categoriaDAO.getAll();
		request.setAttribute("listOfBooks", listOfBooks);
		request.setAttribute("listOfCategories", listOfCategories);

		if (listOfBooks != null && listOfBooks.size() != 0) { return "showBooks.jsp"; }  else { return "insertBookForm.jsp"; }
	}

}
