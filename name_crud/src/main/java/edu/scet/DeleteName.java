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
 * Servlet implementation class DeleteName
 */
@WebServlet("/DeleteName")
public class DeleteName extends HttpServlet {
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    // doGet(request, response);

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    int txtid = Integer.parseInt(request.getParameter("txtid"));

    Connection con = null;
    PreparedStatement pst = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/name_db", "root", "");

        String query = "DELETE FROM name_tbl WHERE u_id = ?";
        pst = con.prepareStatement(query);

        pst.setInt(1, txtid);

        int status = pst.executeUpdate();

        if (status > 0) {
            out.println("<h2>Record Deleted successfully.</h2>");
        } else {
            out.println("<h2>Error in Delete Record ..</h2>");
        }

        out.println("<a href='nameform.jsp'>Back to Form</a>");
    } catch (Exception e) {
        e.printStackTrace();
        out.println("<h2>Error in Delete Data</h2>");
    } finally {
        try {
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
