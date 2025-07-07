package edu.scet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Response ka content type set karo
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 1. Employee object banao aur form ka data usme set karo
        Employee emp = new Employee();
        emp.setU_name(request.getParameter("u_name"));
        emp.setU_contact(request.getParameter("u_contact"));
        emp.setU_email(request.getParameter("u_email"));
        emp.setU_password(request.getParameter("u_password"));

        // Debugging: Console me form ka data print karo (optional)
        System.out.println("Name: " + emp.getU_name());
        System.out.println("Contact: " + emp.getU_contact());
        System.out.println("Email: " + emp.getU_email());
        System.out.println("Password: " + emp.getU_password());

        int status = 0;

        try {
            // 2. MySQL JDBC driver load karo
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3. Database se connection banao
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/form_db", "root", "");

            // 4. Data insert karne ke liye SQL statement prepare karo
            String sql = "INSERT INTO form_tbl (u_name, u_contact, u_email, u_password) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            // 5. SQL query me form ka data Employee object se set karo
            stmt.setString(1, emp.getU_name());
            stmt.setString(2, emp.getU_contact());
            stmt.setString(3, emp.getU_email());
            stmt.setString(4, emp.getU_password());

            // 6. SQL query ko execute karo
            status = stmt.executeUpdate();

            // 7. Connection band karo
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 8. Insert hone ke status ke hisaab se message dikhana
        if (status > 0) {
            out.println("<h2>Data safaltapoorvak insert ho gaya!</h2>");
        } else {
            out.println("<h2>Data insert karne me asafalta rahi!</h2>");
        }

        // 9. Wapas form par jaane ke liye link
        out.println("<p><a href='index.html'>Form par wapas jaayein</a></p>");
    }
}
