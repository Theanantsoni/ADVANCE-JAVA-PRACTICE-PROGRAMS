package edu.scet; // Ye package ka naam hai - aapke project ke folder ka structure

// Jaruri Java aur Servlet classes import kar rahe hain
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Is Servlet ka URL mapping "/UpdateServlet" hai (browser me ye likhne se chalega)
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // doPost method tab call hota hai jab HTML form POST method se data bhejti hai
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Response ka content type HTML set kiya
        response.setContentType("text/html");

        // PrintWriter object banaya jisse HTML content client ko bhej sakte hain
        PrintWriter out = response.getWriter();

        // ================================
        // Step 1: Form se aayi values ko Employee class me set kar rahe hain
        // ================================
        Employee emp = new Employee(); // Employee class ka object banaya

        // Form se aaye parameters ko Employee object me set kiya
        emp.setU_id(Integer.parseInt(request.getParameter("u_id")));       // ID ko int me convert karke set kiya
        emp.setU_name(request.getParameter("u_name"));                     // Name
        emp.setU_contact(request.getParameter("u_contact"));               // Contact
        emp.setU_email(request.getParameter("u_email"));                   // Email
        emp.setU_password(request.getParameter("u_password"));             // Password

        // ================================
        // Step 2: Database connection aur SQL query
        // ================================
        Connection con = null;
        PreparedStatement pst = null;

        try {
            // MySQL JDBC driver load kiya
            Class.forName("com.mysql.cj.jdbc.Driver");

            // MySQL database se connection banaya (form_db = database name)
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/form_db", "root", "");

            // SQL update query prepare ki gayi (placeholders ? ke sath)
            String query = "UPDATE form_tbl SET u_name = ?, u_contact = ?, u_email = ?, u_password = ? WHERE u_id = ?";
            pst = con.prepareStatement(query); // PreparedStatement object banaya

            // PreparedStatement me Employee object se values set ki gayi
            pst.setString(1, emp.getU_name());      // 1st ? = name
            pst.setString(2, emp.getU_contact());   // 2nd ? = contact
            pst.setString(3, emp.getU_email());     // 3rd ? = email
            pst.setString(4, emp.getU_password());  // 4th ? = password
            pst.setInt(5, emp.getU_id());           // 5th ? = ID (WHERE clause)

            // Query execute ki aur update ka result rows me mila
            int rows = pst.executeUpdate();

            // Agar kam se kam ek row update hui, to success message
            if (rows > 0) {
                out.println("<h2>Data Updated Successfully using Employee class!</h2>");
            } else {
                // Agar koi row update nahi hui, to ID galat ho sakti hai
                out.println("<h2>Update Failed. Invalid ID?</h2>");
            }

            // Wapas jaane ke liye link diya
            out.println("<a href='index.html'>Go Back</a>");

        } catch (Exception e) {
            // Agar koi exception aaya to use print karo aur error message dikhao
            e.printStackTrace();
            out.println("<h2>Error occurred while updating data.</h2>");
        } finally {
            // Har hal me resources close karna jaruri hai (best practice)
            try {
                if (pst != null) pst.close();  // PreparedStatement close
                if (con != null) con.close();  // Connection close
            } catch (SQLException ex) {
                ex.printStackTrace(); // Agar close karte waqt bhi error aaye to usko bhi print karo
            }
        }
    }
}
