<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@page import = "databaseH.Libro" %>
<%
	int isbn = Integer.parseInt(request.getParameter("isbn"));
	String title = request.getParameter("title");
	int author = Integer.parseInt(request.getParameter("author"));
	int category = Integer.parseInt(request.getParameter("category"));
	Libro libro = new Libro(isbn, author, category, title);
	libro.save(); // salvar method
	response.sendRedirect("showBooks.jsp");
%>
<body>

</body>
</html>
