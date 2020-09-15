<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="databaseH.*" %>
<%
	try
	{
		//String isbn = request.getParameter("isbn");
		Libro libro = new Libro(request.getParameter("isbn"), null, null, null);
		libro.delete();
		response.sendRedirect("showBooks.jsp");	
	} catch (DataBaseException e) {
		out.println(e.getMessage());
	}
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