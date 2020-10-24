package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Libro;
import jpa.LibroDAOJPAImpl;

public class deleteBookAction extends Action
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			new LibroDAOJPAImpl().delete(new Libro(Integer.parseInt(request.getParameter("isbn"))));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "showBooks.do";
	}

}
