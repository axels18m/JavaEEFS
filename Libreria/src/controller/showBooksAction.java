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
import service.LibrosImplService;

public class showBooksAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		LibrosImplService service = new LibrosImplService();
		List<Libro> listOfBooks = service.getAll();
		List<Categoria> listOfCategories = service.getAllCategories();
		request.setAttribute("listOfBooks", listOfBooks);
		request.setAttribute("listOfCategories", listOfCategories);

		if (listOfBooks != null && listOfBooks.size() != 0) { return "showBooks.jsp"; }  else { return "insertBookForm.jsp"; }
	}

}
