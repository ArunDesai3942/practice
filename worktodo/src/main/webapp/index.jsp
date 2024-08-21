<%@page import= "java.sql.*" %>
<%@page import="jakarta.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TO Do List</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h1>To Do List</h1>
<form action="add" method="post">
<input type="text" name="task" placeholder="new task" required>
<input type=submit value="Add Task">
<ul>
<%
  try{
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","arun");
	  PreparedStatement pstmt=con.prepareStatement("select * from tasktodo");
	  ResultSet rs=pstmt.executeQuery();
	  while(rs.next())
	  {
		  int id=rs.getInt("id");
		String task=rs.getString("task");
		
		%>
		<li>
			<%= task %>
			<a href="delete?id=<%= id %>">Delete</a>
		</li>
		<%
	  }
		con.close();
  }catch(Exception e){
	 e.printStackTrace();
  }
		%>

</ul>
</form>
</body>
</html>