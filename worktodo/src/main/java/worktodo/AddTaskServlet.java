package worktodo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddTaskServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String task = request.getParameter("task");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "arun");
			PreparedStatement pstmt=con.prepareStatement("insert into tasktodo (task) values(?)");
			pstmt.setString(1, task);
			pstmt.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.err.println(e);
		}
		response.sendRedirect("index.jsp");
	}

}
