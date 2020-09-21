<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entity.Libro" %>
<%@ page import="databaseH.*" %>
<%
	try
	{
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		Libro libro = new Libro(isbn);
		libro.delete();
		response.sendRedirect("showBooks.jsp");	
	} catch (DataBaseException e) {
		System.out.println(e.getMessage());
		throw new DataBaseException("Error al eliminar libro: " + e.getMessage());
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>