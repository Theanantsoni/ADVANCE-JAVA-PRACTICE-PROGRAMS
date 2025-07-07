package edu.scet;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Servlet GET request handle karega
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // HTML start
        out.println("<html><head><title>All Data</title></head><body>");
        out.println("<h2>All User Data</h2>");
        out.println("<table border='1' cellpadding='10'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Contact</th><th>Email</th><th>Password</th></tr>");

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // JDBC driver load karo
            Class.forName("com.mysql.cj.jdbc.Driver");

            // DB se connect karo
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/form_db", "root", "");

            // SQL query chalao
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM form_tbl");

            // ResultSet loop karo
            while (rs.next()) {
                int id = rs.getInt("u_id");
                String name = rs.getString("u_name");
                String contact = rs.getString("u_contact");
                String email = rs.getString("u_email");
                String password = rs.getString("u_password");

                // Table row print karo
                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + contact + "</td>");
                out.println("<td>" + email + "</td>");
                out.println("<td>" + password + "</td>");
                out.println("</tr>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<tr><td colspan='5'>Error fetching data</td></tr>");
        } finally {
            // DB close karo
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        out.println("</table>");
        out.println("<br><a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }
}
