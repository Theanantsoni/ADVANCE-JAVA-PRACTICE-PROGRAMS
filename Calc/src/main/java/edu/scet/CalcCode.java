package edu.scet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcCode
 */
@WebServlet("/CalcCode")
public class CalcCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String reqNum1 = request.getParameter("num1");
		String reqNum2 = request.getParameter("num2");
		
		if(reqNum1 == null || reqNum2 == null || reqNum1.isEmpty() || reqNum2.isEmpty())
		{
			response.getWriter().append("Please Enter the Valid Numbers...");
		}
		
		double num1 = Double.parseDouble(reqNum1);
		double num2 = Double.parseDouble(reqNum2);
		double result;
		
		if(request.getParameter("btnadd") != null)
		{
			result = num1 + num2;
			response.getWriter().append("Addition is : " +result);
		}
		else if(request.getParameter("btnsub") != null)
		{
			result = num2 - num1;
			response.getWriter().append("Subtraction is : " +result);
		}
		else if(request.getParameter("btnmul") != null)
		{
			result = num1 * num2;
			response.getWriter().append("Multiplication is : " +result);
		}
		else if(request.getParameter("btndiv") != null)
		{
			result = num2 / num1;
			response.getWriter().append("Division is : " +result);
		}
		else
		{
			response.getWriter().append("Invalid Numbers..");
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
