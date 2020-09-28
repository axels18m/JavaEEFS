<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entity.Libro" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<form action ="filter.do" name ="filterCategory">
		<div class="input-group mb-3">
		 	<div class="input-group-prepend">
		    	<label class="input-group-text" for="inputGroupSelect01">Options</label>
		 	</div>
			<select class="custom-select" name="category">
				<c:forEach var="category" items="${listOfCategories}">
					<option value="${category.id}">${category.description}</option>
				</c:forEach>
			</select>
			<input type = "submit" values = "filter"/>
		</div>
	</form>
	<br/>
	
	<table class= "table">
		<thead class= "table-dark">
			<tr>
				<th scope="col">ISBN</th>
				<th scope="col">Author</th>
				<th scope="col">Title</th>
				<th scope="col">Category</th>
				<th scope="col">Category</th>
				<th scope="col">Edit</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="libro" items="${listOfBooks}">
				<tr>
					<td scope="row">${libro.isbn}</td>
					<td>${libro.author}</td>
					<td>${libro.cat.description}</td>
					<td>${libro.title}</td>
					<td><a href = "deleteBook.do?isbn=${libro.isbn}">Delete</a></td>
					<td><a href = "editBookForm.do?isbn=${libro.isbn}">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<button><a href = "insertBookForm.do">New Book</a></button>
	</table>	
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>