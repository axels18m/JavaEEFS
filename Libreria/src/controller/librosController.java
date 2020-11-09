package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class librosController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/* Provides the facility of dispatching the request to another resource (jsp, servlet, html, etc). */
		String url = request.getServletPath();
		Action action = Action.getAction(url.substring(1, url.length() - 3));
		RequestDispatcher dispatcher = request.getRequestDispatcher(action.execute(request, response));
		dispatcher.forward(request, response);
	}
}
