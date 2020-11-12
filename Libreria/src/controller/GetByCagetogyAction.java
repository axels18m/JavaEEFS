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
import jpa.LibroDAOJPAImpl;
import service.CategoriaService;
import service.LibrosImplService;
import service.LibrosService;

public class GetByCagetogyAction extends Action 
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		LibrosService service = (LibrosService) getBean("servicioLibros", request);
		CategoriaService cat = (CategoriaService) getBean("servicioCategorias", request);
		List<Libro> listOfBooks = null;
		List<Categoria> listOfCategories = service.getAllCategories();
		
		if (request.getParameter("category") == null || request.getParameter("category").equals("select")) {
			listOfBooks = service.getAll();
		} else {
			listOfBooks = service.getByCategory(cat.getById(Integer.parseInt(request.getParameter("category"))));
		}
		
		request.setAttribute("listOfBooks", listOfBooks);
		request.setAttribute("listOfCategories", listOfCategories);
		
		return "showBooks.jsp";
	}
}
