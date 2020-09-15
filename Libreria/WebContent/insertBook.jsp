<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="databaseH.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "showBooks.jsp" method = "post"> <!-- FormularioInsertarLibro -->
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
			
			<p>
				<label for="category">Category :</label>
				<input id="category" type="text" name="category"/>
			</p>
			
			<a href = "insertBookForm"><button value = "insert" type="submit">Insert</button></a>
			<button value = "delete" type="reset">Delete</button>
			<a href = "showBooks.jsp"><button>Cancel</button></a>
		</fieldset>
	</form>
</body>
</html>