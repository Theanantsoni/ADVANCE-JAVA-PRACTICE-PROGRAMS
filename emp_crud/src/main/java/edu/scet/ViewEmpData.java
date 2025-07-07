package edu.scet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewEmpData
 */
@WebServlet("/ViewEmpData")
public class ViewEmpData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmpData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>All Data</title></head><body>");
        out.println("<h2>All User Data</h2>");
        out.println("<table border='1' cellpadding='10'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Gender</th><th>Email</th><th>Contact</th><th>Password</th><th>Address</th><th>Country</th><th>State</th><th>Hobby</th></tr>");

		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db", "root", "");
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM  emp_tbl");
			
			while(rs.next())
			{
				int id = rs.getInt("e_id");
				String name = rs.getString("e_name");
				String gender = rs.getString("e_gender");
				String email = rs.getString("e_email");
				String contact = rs.getString("e_contact");
				String password = rs.getString("e_password");
				String address = rs.getString("e_address");
				String country = rs.getString("e_country");
				String state = rs.getString("e_state");
				String hobby = rs.getString("e_hobby");
				
				out.println("<tr>");
				out.println("<td>" + id + "</td>");
				out.println("<td>" + name + "</td>");
				out.println("<td>" + gender + "</td>");
				out.println("<td>" + email + "</td>");
				out.println("<td>" + contact + "</td>");
				out.println("<td>" + password + "</td>");
				out.println("<td>" + address + "</td>");
				out.println("<td>" + country + "</td>");
				out.println("<td>" + state + "</td>");
				out.println("<td>" + hobby + "</td>");
				out.println("</tr>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("<tr><td colspan='5'>Error Fetching Data" +e.getMessage() + "</tr></td>");
		}
		finally
		{
			try
			{
				if(rs != null)
				{
					rs.close();
				}
				
				if(con != null)
				{
					con.close();
				}
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		out.println("</table>");
        out.println("</body></html>");
	}
}
