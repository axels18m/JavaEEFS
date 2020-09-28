package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseH.DataBaseException;
import entity.Libro;

public class filterAction extends Action
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			List<Libro> listOfBooks = new Libro().getByCategory(Integer.parseInt(request.getParameter("category")));
			request.setAttribute("listOfBooks", listOfBooks);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "showBooks.do";
	}
}
