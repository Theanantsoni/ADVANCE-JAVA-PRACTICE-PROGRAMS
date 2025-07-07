package edu.scet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.scet.dao.RegisterDAO;
import edu.scet.model.StudentGUIBean;

/**
 * Servlet implementation class RegisterStudent
 */
@WebServlet("/RegisterStudent")
public class RegisterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirectPage=null;
		StudentGUIBean studReg = new StudentGUIBean();
		studReg.setNm(request.getParameter("nm"));
		studReg.setPwd(request.getParameter("pwd"));
		studReg.setAddr(request.getParameter("addr"));
		studReg.setContact(request.getParameter("contact"));
		studReg.setEmailId(request.getParameter("emailId"));
		RegisterDAO regDao = new RegisterDAO();
		boolean retVal = regDao.register(studReg);
		if (retVal) {
			HttpSession session = request.getSession(true);
			session.setAttribute("nm", studReg.getNm());
			redirectPage="Home.jsp";
		} else {
			redirectPage="Error.jsp";
		}
		request.getRequestDispatcher(redirectPage).forward(request, response);
	}
}
