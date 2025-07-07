package edu.scet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchStudInto
 */
@WebServlet("/FetchStudInto")
public class FetchStudInto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchStudInto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql//localhost:3306/et24mtca108", "root", "");
			Statement stmt = con.createStatement();
			
			StudInfoBean stud = null;
			List<StudInfoBean> studInfoList = new ArrayList<StudInfoBean>();
			
			String query = "SELECT * FROM tbl_stud_info";
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				stud = new StudInfoBean();
				stud.setStudId(rs.getInt(1));
				stud.setStudName(rs.getString(2));
				stud.setStudName(rs.getString(3));
				stud.setStudMobile(rs.getString(4));
				stud.setStudEmail(rs.getString(5));
				stud.setStudAge(rs.getInt(6));
			}
			
			request.setAttribute("studInfoList", studInfoList);
			
			request.getRequestDispatcher("ShowStudInfo.jsp").forward(request, response);
		} catch (Exception e) {
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
