<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demostración de JSP</title>
</head>
<body>
<% for(int i = 1; i <= 6; i++) { %>
<h1>Hola <%=java.time.LocalDateTime.now() %></h1>
<% } %>
</body>
</html>