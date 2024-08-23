<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=yellow text=blue>
<h1>
<%java.util.Date d= new java.util.Date(); %>
<%=d.getHours() %>:<%=d.getMinutes() %><%=d.getSeconds() %>
</h1>

</body>
</html>