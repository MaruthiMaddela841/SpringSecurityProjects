<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Random" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Offers Page</title>
</head>
<body>
	<h1 style='color:red;text-align:center'>
	Welcome to SBI-Bank ------- Show Balance Page
	</h1>
	<b>BALANCE:: <%= new Random().nextInt(100000) %></b><br/><br/>
	<a href="./">Home</a><br/><br/>
	<a href="logout">Logout</a>
</body>
</html>