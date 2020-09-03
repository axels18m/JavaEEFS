<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="databaseH.Libro"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id = "insertForm" action = "insertBook.do">
		<fieldset>
			<legend>Formulario Alta Libro</legend>
			<p>
				<label for = "isbn">ISBN:</label>
				<input type = "text" id = "ibsn" name = "isbn">
			</p>
			
			<p>
				<label for = "author">Author:</label>
				<input type = "text" id = "author" name = "author">
			</p>
			
			<p>
				<label for = "category">Categoria:</label>
				<input type = "text" id = "category" name = "category">
			</p>
			
			<p>
				<label for = "title">Title:</label>
				<input type = "text" id = "title" name = "title">
			</p>
		</fieldset>
		<!--<a href = "FormEditarLibro.jsp?id_lib=% Libro.insert(); >">Save</a>   -->
	</form>
</body>
</html>