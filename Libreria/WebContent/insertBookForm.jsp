<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="databaseH.*" %>

<% try 
	{
		//String isbn= request.getParameter("isbn");
		//String author= request.getParameter("author");
		//String titulo= request.getParameter("title");
		//String categoria= request.getParameter("category");
		Libro libro= new Libro(request.getParameter("isbn"), request.getParameter("author"), request.getParameter("title"), request.getParameter("category"));
		libro.insert();
		response.sendRedirect("showBooks.jsp");
	} catch (DataBaseException e) { %>
		<%=e.getMessage()%>
	<%}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  
	<h1>Alta de Libros</h1>
	<form action = "showBooks.jsp"> <!-- FormularioInsertarLibro 
		<fieldset>
			<legend>Create new record of Libros.</legend>
			
			<p>
				<label for="isbn">ISBN:</label>
				<input  id="isbn" type="text" name="isbn"/>
			</p> 
			
			<p> 
				<label for="author">Author:</label>
				<input id="author" type="text" name= "author"/>
			</p>
			
			<p> 
				<label for="title">Titulo:</label>
				<input id="title" type="text" name= "title"/>
			</p>
			
			<select name = "category" id = "category">
				<option value = "select">seleccionar</option>
				<
					List<String> listOfCategories = null;
					listOfCategories = Libro.getAllCategories();
					pageContext.setAttribute("listofCategories", listOfCategories);
				%>
				
				<c:forEach var = "category" items = "${ listOfCategories }">
					<option value = "${ category }"> ${ category }</option>
				</c:forEach>
			</select>
			
			<button value = "insert" type="submit">Insert</button>
		</fieldset>
	</form>
	<br>
	-->
</body>
</html>