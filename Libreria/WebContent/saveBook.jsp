<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import = "databaseH.*" %>
<%@ page import="jpa.*" %>
<%@ page import="entity.Libro" %>
<%
	int isbn = Integer.parseInt(request.getParameter("isbn"));
	String title = request.getParameter("title");
	int author = Integer.parseInt(request.getParameter("author"));
	int category = Integer.parseInt(request.getParameter("category"));
	new LibroDAOJPAImpl().save(new Libro(isbn, author, category, title));
	response.sendRedirect("showBooks.jsp");
%>
