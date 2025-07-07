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
 * Servlet implementation class DeleteEmpData
 */
@WebServlet("/DeleteEmpData")
public class DeleteEmpData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmpData() {
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
		
		int e_id = Integer.parseInt(request.getParameter("txtid"));
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db", "root", "");
			
			String query = "DELETE FROM emp_tbl WHERE e_id = ?";
			pst = con.prepareStatement(query);
			
			pst.setInt(1, e_id);
			
			int status = pst.executeUpdate();
			
			if(status > 0)
			{
				out.println("Data Deleted Successfully");
			}
			else
			{
				out.println("No Data Found With " + e_id + " Id");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("Error while Deleting Data : " + e.getMessage());
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
