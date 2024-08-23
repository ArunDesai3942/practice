<% String s=request.getParameter("operation");
if(s.equals("Addition")){%>
<jsp:forward page="add.jsp"></jsp:forward>
<%}else if(s.equals("Subtraction")){%>
<jsp:forward page="sub.jsp"></jsp:forward>
<%}else if(s.equals("Multiplication")){%>
<jsp:forward page="mul.jsp"></jsp:forward>
<%} else { %>
<jsp:forward page="div.jsp"/> 
<% }  %>