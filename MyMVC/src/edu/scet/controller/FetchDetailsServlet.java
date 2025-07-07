package edu.scet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.scet.dao.FetchStudentDAO;
import edu.scet.model.StudentBean;

/**
 * Servlet implementation class FetchDetailsServlet
 */
@WebServlet("/FetchDetailsServlet")
public class FetchDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FetchStudentDAO fetchDao = new FetchStudentDAO();
		StudentBean sb = fetchDao.getStudentDetails((String)request.getSession().getAttribute("nm"));
		if (sb!=null) {
			request.setAttribute("sb", sb);
			request.getRequestDispatcher("ViewDetails.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
	}
}
