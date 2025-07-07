package edu.scet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class codefile
 */
@WebServlet("/codefile")
public class codefile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public codefile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String reqEmail = request.getParameter("txtemail");
		String reqPass = request.getParameter("txtpass");
		
		if(reqEmail.trim().equals("anant@gmail.com") && reqPass.trim().equals("6317"))
		{
			response.sendRedirect("http://localhost:8080/Form_Submit_Success_or_Error_Display/success");
		}
		else
		{
			response.sendRedirect("http://localhost:8080/Form_Submit_Success_or_Error_Display/error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
