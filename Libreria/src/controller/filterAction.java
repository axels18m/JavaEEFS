package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LibroDAO;
import entity.Libro;
import jpa.LibroDAOJPAImpl;

public class filterAction extends Action
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		List<Libro> listOfBooks; 
		try {
			listOfBooks = new LibroDAOJPAImpl().getByCategory(Integer.parseInt(request.getParameter("category")));
		} catch (NumberFormatException e) {
			listOfBooks = new LibroDAOJPAImpl().getAll();
		}
		request.setAttribute("listOfBooks", listOfBooks);
		return "showBooks.do";
	}
}
