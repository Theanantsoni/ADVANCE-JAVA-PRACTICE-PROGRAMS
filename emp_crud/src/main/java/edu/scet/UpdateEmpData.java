package edu.scet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateEmpData
 */
@WebServlet("/UpdateEmpData")
public class UpdateEmpData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmpData() {
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
		
		emp.setE_id(Integer.parseInt(request.getParameter("txtid")));
		emp.setE_name(request.getParameter("txtname"));
		emp.setE_gender(request.getParameter("selgen"));
		emp.setE_email(request.getParameter("txtemail"));
		emp.setE_contact(request.getParameter("txtcontact"));
		emp.setE_password(request.getParameter("txtpassword"));
		emp.setE_address(request.getParameter("txtaddress"));
		emp.setE_country(request.getParameter("selcountry"));
		emp.setE_state(request.getParameter("selstate"));
		
		String[] hobbies = request.getParameterValues("chkhobby");
		if(hobbies != null)
		{
			String hobbyString = String.join(",", hobbies);
			emp.setE_hobby(hobbyString);
		}
		else
		{
			emp.setE_hobby("");
		}
		
		int status = 0;
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","");
			
			String query = "UPDATE emp_tbl SET e_name = ?, e_gender = ?, e_email = ?, e_contact = ?, e_password = ?, e_address = ?, e_country = ?, e_state = ?, e_hobby = ? WHERE e_id = ?";
			
			pst = con.prepareStatement(query);
			
			pst.setString(1, emp.getE_name());
			pst.setString(2, emp.getE_gender());
			pst.setString(3, emp.getE_email());
			pst.setString(4, emp.getE_contact());
			pst.setString(5, emp.getE_password());
			pst.setString(6, emp.getE_address());
			pst.setString(7, emp.getE_country());
			pst.setString(8, emp.getE_state());
			pst.setString(9, emp.getE_hobby());
			pst.setInt(10, emp.getE_id());
			
			status = pst.executeUpdate();
			
			if(status > 0)
			{
				out.println("Data Updated Successfully");
			}
			else
			{
				out.println("Updated Faild. Invalid Id.");
			}
		}
		catch(Exception e)
		{
		    e.printStackTrace(); // Already present
		    out.println("Error while updating: " + e.getMessage());
		}

		finally
		{
			try
			{
				if(pst != null)
				{
					pst.close();
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
	}
}
