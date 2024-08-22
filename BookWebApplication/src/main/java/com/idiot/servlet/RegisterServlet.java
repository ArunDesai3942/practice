package com.idiot.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final String query="insert into book(bookname,bookedition,bookprice) values(?,?,?)" ;

    
    public RegisterServlet() {

    
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//get PrintWriter
		PrintWriter pw= res.getWriter();
    //set content type
		res.setContentType("text/html");
	//Get book info
		String bookName=req.getParameter("bookName");
		String bookEdition =req.getParameter("bookEdition");
		float bookPrice=Float.parseFloat(req.getParameter("bookPrice"));
		
		//load jdbc driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	//generate the connection
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","arun")){
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1,bookName );
			pstmt.setString(2,bookEdition);
			pstmt.setFloat(3, bookPrice);
			int count=pstmt.executeUpdate();
			if(count==1) {
				pw.println("<h2>Record Inserted Successfully</h2>");
			}
			else {
				pw.println("<h2>Record NOt Inserted </h2>");
			}
		}catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1>"+e.getMessage()+"</h1>");
		}
		pw.println("<a href='home.html'>Home</a>");
		pw.println("<br");
		pw.println("<a href='bookList'>Book List</a>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
		
	}

}
