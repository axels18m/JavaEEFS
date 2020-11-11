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

public class filterAction extends Action
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		List<Libro> listOfBooks; 
		LibrosService service = (LibrosService) getBean("servicioLibros", request);
		CategoriaService catService = (CategoriaService) getBean("servicioLibros", request);
		List<Categoria> listOfCategories = catService.getAll();
		
		try {
			listOfBooks = service.getByCategory(catService.getById(Integer.parseInt(request.getParameter("category"))).getId());
		} catch (NumberFormatException e) {
			listOfBooks = service.getAll();
		}
		request.setAttribute("listOfBooks", listOfBooks);
		request.setAttribute("listOfCategories", listOfCategories);
		return "showBooks.do";
	}
}
