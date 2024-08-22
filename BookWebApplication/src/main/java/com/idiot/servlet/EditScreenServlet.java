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
 * Servlet implementation class EditScreenServlet
 */
@WebServlet("/editScreen")
public class EditScreenServlet extends HttpServlet {
	private static final String query="select bookid,bookname,bookedition,bookprice from book where bookid=?" ;

    
    public EditScreenServlet() {

    
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//get PrintWriter
		PrintWriter pw= res.getWriter();
    //set content type
		res.setContentType("text/html");
	//Get book info
		
		int bookid=Integer.parseInt(req.getParameter("bookid"));
		//load jdbc driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	//generate the connection
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","arun");
			PreparedStatement pstmt=con.prepareStatement(query);){
			pstmt.setInt(1,bookid);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			pw.println("<form action='editUrl' method='post'>");
			pw.println("<table align='center'>");
			pw.println("<tr>");
			pw.println("<td>Book Id</td>");
			pw.println("<td><input type='number' name='bookid' value='"+rs.getInt(1)+"'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Book Name</td>");
			pw.println("<td><input type='text' name='bookName' value='"+rs.getString(2)+"'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Book Edition</td>");
			pw.println("<td><input type='text' name='bookEdition' value='"+rs.getString(3)+"'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Book Price</td>");
			pw.println("<td><input type='text' name='bookPrice' value='"+rs.getFloat(4)+"'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td><input type='submit' value='Edit'</td>");
			pw.println("<td><input type='reset' value='Cancel'</td>");
			pw.println("");
			pw.println("</tr>");
			pw.println("</table>");
			pw.println("</form>");
			
		
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
