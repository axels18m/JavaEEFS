<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="databaseH.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<% Libro libro= Libro.getById(request.getParameter("isbn"));%> <!-- Libro.buscarPorClabe -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action ="MostrarLibros.jsp" method = "post">
		<%
			List<Libro> listOfBooks = null;
			if (request.getParameter("category") == null || request.getParameter("category").equals("select"))
			{
				listOfBooks = Libro.getAll();
			} else {
				listOfBooks = Libro.gettByCategory(request.getParameter("category"));
			}
			
			for (Libro book: listOfBooks)
			{
				%>
				<% book.getIsbn(); %>
				<% book.getAuth_lib(); %>
				<% book.getCat_lib(); %>
				<% book.getTit_lib(); %>
				
				<a href = "BorrarLibro.jsp?id_lib=<% book.getIsbn(); %>">Borrar</a>
				<a href = "FormEditarLibro.jsp?id_lib=<% book.getIsbn(); %>">Editar</a>
				<br/>
			<% } %>
		
	</form>

	<select name = "category" id = "category">
		<option value = "select">seleccionar</option>
		<%
			List<String> listOfCategories = null;
			listOfCategories = Libro.getAllCategories();
			pageContext.setAttribute("listofCategories", listOfCategories);
		%>
		
		<c:forEach var = "category" items = "${ listOfCategories }">
			<option value = "${ category }"> ${ category }</option>
		</c:forEach>
	</select>
	<input type = "submit" values = "Filter"/><br/>
		
</body>
</html>