<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Offers Page</title>
</head>
<body>
	<h1 style='color:red;text-align:center'>
	Authorization Failed for 
	<%=SecurityContextHolder.getContext().getAuthentication().getName() %>
	</h1>
	<a href="./">Home</a>
</body>
</html>