package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Categoria;
import entity.Libro;

public class showBooksAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<Libro> listOfBooks = null;
		List<Categoria> listOfCategories = null;
		try {
			listOfBooks = Libro.getAll();
			listOfCategories = Categoria.getAll();
			request.setAttribute("listOfBooks", listOfBooks);
			request.setAttribute("listOfCategories", listOfCategories);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (listOfBooks != null && listOfBooks.size() != 0) { return "showBooks.jsp"; }  else { return "insertBookForm.jsp"; }
	}

}
