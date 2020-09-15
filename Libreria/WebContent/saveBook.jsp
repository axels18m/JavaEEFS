<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@page import = "databaseH.Libro" %>
<%
	String cve_lib = request.getParameter("cve_lib");
	String tit_lib = request.getParameter("tit_lib");
	String aut_lib = request.getParameter("aut_lib");
	String cat_lib = request.getParameter("category");
	Libro libro = new Libro(cve_lib, aut_lib, cat_lib, tit_lib);
	libro.save(); // salvar method
	response.sendRedirect("showBooks.jsp");
%>
<body>

</body>
</html>
