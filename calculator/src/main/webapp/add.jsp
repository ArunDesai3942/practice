<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=red text=yellow>
<h1>
<%String s1=request.getParameter("first");
String s2=request.getParameter("second");
int x=Integer.parseInt(s1);
int y=Integer.parseInt(s2);
out.println("Output:"+(x+y));
%>
</h1>

</body>
</html>