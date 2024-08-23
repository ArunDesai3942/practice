<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body bgcolor=yellow text=blue>
<h1>
<jsp:useBean id="mb" class="jsp.MessageBean"></jsp:useBean>
<jsp:setProperty property="message" name="mb" value="welcome" />
<jsp:getProperty name="mb" property="message"/>
</h1>

</body>
</html>