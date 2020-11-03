<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jpa.*" %>
<%@ page import="entity.*" %>
<%@ page import="databaseH.*" %>
<%
	new LibroDAOJPAImpl().delete(new Libro(Integer.parseInt(request.getParameter("isbn"))));
	response.sendRedirect("showBooks.jsp");
%>