package edu.scet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet") // Form is URL se call karega
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Response ko HTML set karo
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Form se id lo
        int u_id = Integer.parseInt(request.getParameter("u_id"));

        // DB variables
        Connection con = null;
        PreparedStatement pst = null;

        try {
            // JDBC driver load karo
            Class.forName("com.mysql.cj.jdbc.Driver");

            // DB se connect karo (form_db)
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/form_db", "root", "");

            // SQL query prepare karo
            String query = "DELETE FROM form_tbl WHERE u_id = ?";
            pst = con.prepareStatement(query);

            // u_id set karo
            pst.setInt(1, u_id);

            // Query execute karo
            int status = pst.executeUpdate();

            // Result print karo
            if (status > 0) {
                out.println("<h2>Record Deleted Successfully!</h2>");
            } else {
                out.println("<h2>No Record Found with ID: " + u_id + "</h2>");
            }

            out.println("<a href='index.html'>Go Back</a>");

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>Error while deleting data.</h2>");
        } finally {
            // Connection close karo
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
