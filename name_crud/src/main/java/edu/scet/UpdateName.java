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
 * Servlet implementation class UpdateName
 */
@WebServlet("/UpdateName")
public class UpdateName extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // doGet(request, response);

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    BeanClassName bcn = new BeanClassName();

    bcn.setTxtid(Integer.parseInt(request.getParameter("txtid")));
    bcn.setTxtname(request.getParameter("txtname"));

    Connection con = null;
    PreparedStatement pst = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/name_db", "root", "");

        String query = "UPDATE name_tbl SET u_name = ? WHERE u_id = ?";

        pst = con.prepareStatement(query);

        pst.setString(1, bcn.getTxtname());
        pst.setInt(2, bcn.getTxtid());

        int rows = pst.executeUpdate();

        if (rows > 0) {
            out.println("<h2>Data updated successfully</h2>");
        } else {
            out.println("<h2>Data Update Error...</h2>");
        }

        out.println("<a href='nameform.jsp'>Back to form</a>");
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}