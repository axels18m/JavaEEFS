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
		CategoriaService category = (CategoriaService) getBean("servicioCategorias", request);
		List<Categoria> listOfCategories = service.getAllCategories();
		
		try {
			listOfBooks = service.getByCategory(category.getById(Integer.parseInt(request.getParameter("category"))));
		} catch (Exception e) {
			listOfBooks = service.getAll();
		}
		request.setAttribute("listOfBooks", listOfBooks);
		request.setAttribute("listOfCategories", listOfCategories);
		return "showBooks.do";
	}
}
