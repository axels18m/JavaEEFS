<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="databaseH.*" %>
<% Libro libro= Libro.getById(request.getParameter("isbn")); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="saveBook.jsp">
		<fieldset>
			<legend>Edit Book Form</legend>
		
			<p>
				<label for = "isbn">ISBN:</label>
				<input type = "text" id ="isbn" name = "isbn" value = "<% libro.getIsbn(); %>"/>
			</p>
			
			<p>
				<label for = "author">Author:</label>
				<input type = "text" id ="author" name = "author" value = "<% libro.getTit_lib(); %>"/>
			</p>
			
			<p>
				<label for = "title">Title:</label>
				<input type = "text" id ="title" name = "title" value = "<% libro.getCat_lib(); %>"/>
			</p>
			
			<select name = "category">
				<%
					List<String> listOfCategories = null;
					listOfCategories = libro.getAllCategories();
					for(String category : listOfCategories)
					{
						if ( libro.getCat_lib().equals(category))
						{
							%>
							<option value = "<%=category%>" selected = "selected"><%=category%></option> 
						<% } else { %>
							<option value="<%=category%>"><%=category%></option>
						<%}
					}
				%>
			</select>
			<button type = "submit">Save</button>
		</fieldset>
	</form>
</body>
</html>
