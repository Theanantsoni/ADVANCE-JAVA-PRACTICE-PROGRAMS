package edu.scet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class InsertName
 */
@WebServlet("/InsertName")
public class InsertName extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    // doGet(request, response);

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    BeanClassName bcn = new BeanClassName();

    bcn.setTxtname(request.getParameter("txtname"));

    System.out.println("Name : " + bcn.getTxtname());

    int status = 0;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/name_db", "root", "");

        String sql = "INSERT INTO name_tbl (u_name) VALUES (?)";
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, bcn.getTxtname());

        status = stmt.executeUpdate();

        con.close();
    } catch (Exception e) {
        System.out.println("Error inserting data: " + e.getMessage());
        e.printStackTrace();
    }

    if (status > 0) {
        out.println("<h2>Data Inserted Successfully.</h2>");
    } else {
        out.println("<h2>Error in Data Insert</h2>");
    }

    out.println("<p><a href='nameform.jsp'>Back to Form</a></p>");
}