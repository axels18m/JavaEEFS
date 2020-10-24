package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Categoria;
import entity.Libro;
import jpa.CategoriaDAOJPAImpl;
import jpa.LibroDAOJPAImpl;

public class showBooksAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<Libro> listOfBooks = null;
		List<Categoria> listOfCategories = null;
		listOfBooks = new LibroDAOJPAImpl().getAll();
		listOfCategories = new CategoriaDAOJPAImpl().getAll();
		request.setAttribute("listOfBooks", listOfBooks);
		request.setAttribute("listOfCategories", listOfCategories);

		if (listOfBooks != null && listOfBooks.size() != 0) { return "showBooks.jsp"; }  else { return "insertBookForm.jsp"; }
	}

}
