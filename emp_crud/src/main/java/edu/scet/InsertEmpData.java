package edu.scet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertEmpData
 */
@WebServlet("/InsertEmpData")
public class InsertEmpData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertEmpData() {
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
		
		EmployeeClass emp = new EmployeeClass();
		
		emp.setE_name(request.getParameter("txtname"));
		emp.setE_gender(request.getParameter("selgen"));
		emp.setE_email(request.getParameter("txtemail"));
		emp.setE_contact(request.getParameter("txtcontact"));
		emp.setE_password(request.getParameter("txtpassword"));
		emp.setE_address(request.getParameter("txtaddress"));
		emp.setE_country(request.getParameter("selcountry"));
		emp.setE_state(request.getParameter("selstate"));
		
//		emp.setE_hobby(request.getParameter("chkhobby"));
		
		
		String[] hobbies = request.getParameterValues("chkhobby");
		if (hobbies != null) 
		{
		    String hobbyString = String.join(",", hobbies); // Combine into comma-separated string
		    emp.setE_hobby(hobbyString);
		} 
		else 
		{
		    emp.setE_hobby("");
		}

		int status = 0;
		
		try 
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db", "root", "");
			
			String sql = "INSERT INTO emp_tbl (e_name, e_gender, e_email, e_contact, e_password, e_address, e_country, e_state, e_hobby) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, emp.getE_name());
			stmt.setString(2, emp.getE_gender());
			stmt.setString(3, emp.getE_email());
			
//			stmt.setLong(4, Long.parseLong(emp.getE_contact()));
			stmt.setString(4, emp.getE_contact());
			
			stmt.setString(5, emp.getE_password());
			stmt.setString(6, emp.getE_address());
			stmt.setString(7, emp.getE_country());
			stmt.setString(8, emp.getE_state());
			stmt.setString(9, emp.getE_hobby());
			
			status = stmt.executeUpdate();
			
			con.close();
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			out.println("Error: " + e.getMessage());
		}
		
		if(status > 0)
		{
			out.println("Data Inserted Successfully.");
		}
		else
		{
			out.println("Data Not Inserted.");
		}
	}

}
