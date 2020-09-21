package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseH.DataBaseException;
import entity.Libro;

public class deleteBookAction extends Action
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			new Libro(Integer.parseInt(request.getParameter("isbn"))).delete();
		} catch (NumberFormatException | DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "showBooks.do";
	}

}
