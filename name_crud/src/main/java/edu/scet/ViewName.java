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
 * Servlet implementation class ViewName
 */
@WebServlet("/ViewName")
public class ViewName extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    // doGet(request, response);

    response.setContentType("text/html");

    PrintWriter out = response.getWriter();

    // out.println("<>")

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/name_db", "root", "");

        stmt = con.createStatement();

        rs = stmt.executeQuery("SELECT * FROM name_tbl");

        while (rs.next()) {
            int id = rs.getInt("u_id");
            String name = rs.getString("u_name");

            out.println("Id : " + id);
            out.println("Name : " + name);
            out.println("<br>");
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("Error Fetching Problem");
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}