<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="databaseH.*" %>

<% try 
	{
		int isbn= Integer.parseInt(request.getParameter("isbn"));
		int author= Integer.parseInt(request.getParameter("author"));
		String title= request.getParameter("title");
		int category= Integer.parseInt(request.getParameter("category"));
		Libro libro = new Libro(isbn, author, category, title);
		libro.insert();
		response.sendRedirect("showBooks.jsp");
	} catch (DataBaseException e) { %>
		<%=e.getMessage()%>
		<%=e.getCause() %>
	<%}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>