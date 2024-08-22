package com.idiot.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/bookList")
public class BookListServlet extends HttpServlet {
	private static final String query="select bookid,bookname,bookedition,bookprice from book" ;

    
    public BookListServlet() {

    
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//get PrintWriter
		PrintWriter pw= res.getWriter();
    //set content type
		res.setContentType("text/html");
	//Get book info
		
		
		//load jdbc driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	//generate the connection
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","arun")){
			PreparedStatement pstmt=con.prepareStatement(query);
			ResultSet rs =pstmt.executeQuery();
			pw.println("<table border='1' align='center'>");
			pw.println("<tr>");
			pw.println("<th>Book Id</th>");
			pw.println("<th>Book Name</th>");
			pw.println("<th>Book Edition</th>");
			pw.println("<th>Book Price</th>");
			pw.println("<th>Edit</th>");
			pw.println("<th>Delete</th>");
			pw.println("</tr>");
			

			while(rs.next()) {
				pw.println("<tr>");
				pw.println("<td>"+rs.getInt(1)+"</td>");
				pw.println("<td>"+rs.getString(2)+"</td>");
				pw.println("<td>"+rs.getString(3)+"</td>");
				pw.println("<td>"+rs.getFloat(4)+"</td>");
				pw.println("<td><a href='editScreen?bookid="+rs.getInt(1)+"'>Edit</a></td>");
				pw.println("<td><a href='deleteurl?bookid="+rs.getInt(1)+"'>Delete</a></td>");

				pw.println("</tr>");
			}
			pw.println("</table>");
		}catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1>"+e.getMessage()+"</h1>");
		}
		pw.println("<a href='home.html'>Home</a>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
		
	}

}
