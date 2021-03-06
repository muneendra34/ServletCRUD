package networking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class NetworkEditServlet
 */
@WebServlet("/NetworkEditServlet")
public class NetworkEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		String ofn = (String) s.getAttribute("ud1");
		ofn = ofn.toLowerCase();
		
		String fn = request.getParameter("fname");
		fn = fn.toLowerCase();
		String ln = request.getParameter("lname");
		ln = ln.toLowerCase();
		String psw = request.getParameter("psw");
		psw = psw.toLowerCase();
		String rpsw = request.getParameter("psw-repeat");
		rpsw = rpsw.toLowerCase();
		String addr = request.getParameter("address");
		addr = addr.toLowerCase();
		String phone = request.getParameter("phone");
		phone = phone.toLowerCase();
		String des = request.getParameter("desig");
		des = des.toLowerCase();
		
		PrintWriter out = response.getWriter();
		NetworkActions ja = new NetworkActions();
		try 
		{	
			int i = ja.goNetworkUpdate(fn,ln,psw,rpsw,addr,phone,des,ofn); 
			if( i != 0)
			{
				out.print("Successfully record updated!!");  
				RequestDispatcher rd = request.getRequestDispatcher("NetworkIndex1");
	            rd.forward(request, response); 
			}
			else
			{
				response.sendRedirect("network/networkupdateerror.html");
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

}
