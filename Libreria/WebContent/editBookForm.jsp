<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page import="entity.Libro" %>
<% Libro libro = Libro.getById(Integer.parseInt(request.getParameter("isbn")));%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="saveBook.do">
		<fieldset>
			<legend>Edit Book Form</legend>
			<p>
				<label for = "isbn">ISBN:</label>
				<input type = "text" id ="isbn" name = "isbn" value = "<%= libro.getIsbn() %>" readonly/>
			</p>
			<p>
				<label for = "author">Author:</label>
				<input type = "text" id ="author" name = "author" value = "<%= libro.getAuthor() %>"/>
			</p>
			
			<p>
				<label for="category">Category:</label>
				<select  name="category">
					<c:forEach var="category" items="${ listOfCategories }">
						<option value="${ category.id }">${ category.description }</option>
					</c:forEach>
				</select><br />
			</p>
			
			<p>
				<label for = "title">Title:</label>
				<input type = "text" id ="title" name = "title" value = "<%= libro.getTitle() %>"/>
			</p>
			<button type = "submit">Save</button>
		</fieldset>
	</form>
</body>
</html>
