package edu.scet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertStudInfo
 */
@WebServlet("/InsertStudInfo")
public class InsertStudInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStudInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String studName = request.getParameter("stud_name");
		String studSurname = request.getParameter("stud_surname");
		String studMobile = request.getParameter("stud_mobile");
		String studEmail = request.getParameter("stud_email");
		int studAge = Integer.parseInt(request.getParameter("stud_age"));
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/et24mtca108", "root", "");
			Statement stmt = con.createStatement();
			
			String query = "INSERT INTO tbl_stud_info(stud_name, stud_surname, stud_mobile, stud_email, stud_age) VALUES('"+studName+"', '"+studSurname+"', '"+studMobile+"', '"+studEmail+"', '"+studAge+"')";
			int row = stmt.executeUpdate(query);
			
			if(row == 1) {
				request.getRequestDispatcher("Success.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			}
		} catch(Exception e) {
			e.printStackTrace();
			response.getWriter().append(e.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
