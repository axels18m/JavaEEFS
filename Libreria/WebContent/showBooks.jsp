<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="databaseH.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action ="showBooks.jsp" method = "post">
		<table>
			<tr>
				<th>ISBN</th>
				<th>Author</th>
				<th>Title</th>
				<th>Category</th>
			</tr>
			<%
				List<Libro> listOfBooks = null;
				if (request.getParameter("category") == null || request.getParameter("category").equals("select"))
				{
					listOfBooks = Libro.getAll();
				} else {
					listOfBooks = Libro.getByCategory(request.getParameter("category"));
				}
				
				for (Libro book: listOfBooks)
				{
					%>
					<tr>
						<td><% book.getIsbn(); %> </td>
						<td><% book.getAuth_lib(); %></td>
						<td><% book.getCat_lib(); %></td>
						<td><% book.getTit_lib(); %></td>
					
						<td><a href = "deleteBook.jsp?id_lib=<% book.getIsbn(); %>">Delete</a></td>
						<td><a href = "editForm.jsp?id_lib=<% book.getIsbn(); %>">Edit</a></td>
					</tr>
				<% } %>
		</table>
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