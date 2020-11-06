package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LibroDAO;
import entity.Libro;
import factory.DAOAbstractFactory;
import factory.DAOFactory;
import jpa.LibroDAOJPAImpl;
import service.LibrosImplService;
import service.LibrosService;

public class deleteBookAction extends Action
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			((LibrosService) getBean("servicioLibros", request)).delete(new Libro(Integer.parseInt(request.getParameter("isbn"))));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "showBooks.do";
	}

}
