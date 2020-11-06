<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "setNewBook.do"> <!-- FormularioInsertarLibro -->
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
				<label for="category">Category:</label>
				<select  name="category">
					<c:forEach var="category" items="${ listOfCategories }">
						<option value="${ category.id }">${ category.description }</option>
					</c:forEach>
				</select><br />
			</p>
			
			<p> 
				<label for="title">Titulo:</label>
				<input id="title" type="text" name= "title"/>
			</p>
			
			<button value = "insert" type="submit">Insert</button>
		</fieldset><button><a href = "showBooks.do">Cancel</a></button>
	</form>
</body>
</html>