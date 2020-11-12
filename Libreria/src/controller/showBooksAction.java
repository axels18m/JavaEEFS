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
import service.CategoriaService;
import service.LibrosImplService;
import service.LibrosService;

public class showBooksAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		LibrosService service = (LibrosService) getBean("servicioLibros", request);
		
		List<Libro> listOfBooks = service.getAll();
		List<Categoria> listOfCategories = ((CategoriaService) getBean("servicioCategorias", request)).getAll();
		request.setAttribute("listOfBooks", listOfBooks);
		request.setAttribute("listOfCategories", listOfCategories);

		if (listOfBooks != null && listOfBooks.size() != 0) { return "showBooks.jsp"; }  else { return "insertBookForm.jsp"; }
	}

}
