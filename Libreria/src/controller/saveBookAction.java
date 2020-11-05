package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import dao.LibroDAO;
import databaseH.DataBaseException;
import entity.Libro;
import factory.DAOAbstractFactory;
import factory.DAOFactory;
import jpa.LibroDAOJPAImpl;
import service.LibrosImplService;

public class saveBookAction extends Action
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		LibrosImplService service = new LibrosImplService();
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		int author = Integer.parseInt(request.getParameter("author"));
		int category = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		
		service.save(new Libro(isbn, author, category, title));
		return "showBooks.do";
	}

}
