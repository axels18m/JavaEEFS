<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page import="databaseH.DataBaseHelper"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Alta de Libros</h1>
	<p>
		<label for = "ID">ID:</label>
		<input type = "text" name = "textfield" id ="ID">
	</p>
	
	<p>
		<label for = "author">Autor:</label>
		<input type = "text" name = "textfield" id ="author">
	</p>
	
	<p>
		<label for = "title">Titulo:</label>
		<input type = "text" name = "textfield" id ="title">
	</p>
	
	<input type = "submit" value = "Insertar" onclick = "validacion():">
	<select name = "category" id = "category">
		<option value = "select">seleccionar:</option>
		<%
			List<String> rs2;
			String query = "SELECT distinc(category) FROM Libro";
			DataBaseHelper<String> helper = new DataBaseHelper<String>();
			rs2 = helper.getRecords(query, String.class); //seleccionar Registros
			
			if  (rs2.size() > 0)
			{
				for (String category : rs2)
				{
					%>
					<option value = "<%=category%>"> <%=category%> </option>
					<% 
				}
			}
		%>
	</select>
	<br>
</body>
</html>