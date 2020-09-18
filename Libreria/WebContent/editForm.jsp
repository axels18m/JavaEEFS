<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="databaseH.*" %>
<% Libro libro = Libro.getById(Integer.parseInt(request.getParameter("isbn"))); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="saveBook.jsp" method = "post">
		<fieldset>
			<legend>Edit Book Form</legend>
			<p>
				<label for = "author">Author:</label>
				<input type = "text" id ="author" name = "author" value = "<% libro.getAuth_lib(); %>"/>
			</p>
			
			<p>
				<label for = "category">Category:</label>
				<input type = "text" id ="title" name = "category" value = "<% libro.getCat_lib(); %>"/>
			</p>
			
			<p>
				<label for = "title">Title:</label>
				<input type = "text" id ="title" name = "title" value = "<% libro.getTit_lib(); %>"/>
			</p>
			
			<!-- 
			<select name = "category">
				<
					List<String> listOfCategories = null;
					listOfCategories = libro.getAllCategories();
					for(String category : listOfCategories)
					{
						if (Integer.toString(libro.getCat_lib()).equals(category))
						{
							%>
							<option value = "<=category>" selected = "selected"><=category%></option> 
						< } else { %>
							<option value="<=category%>"><=category%></option>
						<}
					}
				>
				 
			</select> -->
			<button type = "submit"><a href = "saveBook.jsp?isbn=<%= libro.getIsbn() %>">Save</a></button>
		</fieldset>
	</form>
</body>
</html>
