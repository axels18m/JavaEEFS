package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Categoria;
import entity.Libro;
import service.CategoriaService;
import service.LibrosService;

public class filterAction extends Action
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		List<Libro> listOfBooks; 
		LibrosService service = (LibrosService) getBean("servicioLibros", request);
		List<Categoria> listOfCategories = ((CategoriaService) getBean("servicioCategorias", request)).getAll();
		
		try {
			int id = Integer.parseInt(request.getParameter("category"));
			listOfBooks = service.getByCategory(id);
		} catch (NumberFormatException e) {
			listOfBooks = service.getAll();
		}
		request.setAttribute("listOfBooks", listOfBooks);
		request.setAttribute("listOfCategories", listOfCategories);
		return "showBooks.jsp";
	}
}
