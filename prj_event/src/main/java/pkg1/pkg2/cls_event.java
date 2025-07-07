package pkg1.pkg2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cls_event
 */
@WebServlet("/cls_event")
public class cls_event extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cls_event() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		Enumeration<String> args = request.getParameterNames();
		
		while(args.hasMoreElements())
		{
			String data = args.nextElement();
			out.println(data + ":" +request.getParameter(data)+ "<br>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
//		String NAME = request.getParameter("txtname");
//		response.getWriter().append("\nName is : "+NAME);
//		
//		String EMAIL = request.getParameter("txtemail");
//		response.getWriter().append("\nEmail Id : "+EMAIL);
//		
//		String CONTACT = request.getParameter("numcont");
//		response.getWriter().append("\nContact No : "+CONTACT);
//		
//		String PASS = request.getParameter("txtpass");
//		response.getWriter().append("\nPassword : "+PASS);
		
		
	}

}
