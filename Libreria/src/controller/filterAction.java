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
		try {
			List<Libro> listOfBooks = LibroDAOJPAImpl.getByCategory(Integer.parseInt(request.getParameter("category")));
			request.setAttribute("listOfBooks", listOfBooks);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "showBooks.do";
	}
}
