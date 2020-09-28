package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseH.DataBaseException;
import entity.Libro;

public class setNewBookAction extends Action 
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			int isbn = Integer.parseInt(request.getParameter("isbn"));
			int author = Integer.parseInt(request.getParameter("author"));
			int category = Integer.parseInt(request.getParameter("category"));
			String title = request.getParameter("title");
			new Libro(isbn, author, category, title).insert();
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "showBooks.do";
		return "showBooks.do";
	}
}
