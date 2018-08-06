package testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TestingDevServlet
 */
@WebServlet("/TestingDevServlet")
public class TestingDevServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fn = request.getParameter("fname");
		fn = fn.toLowerCase();
		String ln = request.getParameter("lname");
		ln = ln.toLowerCase();
		String psw = request.getParameter("psw");
		psw = psw.toLowerCase();
		String rpsw = request.getParameter("psw-repeat");
		rpsw = rpsw.toLowerCase();
		boolean brpsw = false;
		if(psw.equals(rpsw))
		{
			brpsw = true;
		}
		String addr = request.getParameter("address");
		addr = addr.toLowerCase();
		String phone = request.getParameter("phone");
		phone = phone.toLowerCase();
		String des = request.getParameter("desig");
		des = des.toLowerCase();
		
		if(brpsw == true)
		{
		TestingDevBean jdb = new TestingDevBean(fn,ln,psw,rpsw,addr,phone,des);
		PrintWriter out = response.getWriter();
		TestingActions ja = new TestingActions();
		try 
		{
			int i = ja.goTestingInsert();
			if( i != 0) 
			{
				response.sendRedirect("testing/testinglogin.html");
			}
			else
			{
				response.sendRedirect("testing/testingdevfailed.html");
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		}
		else
		{
			response.sendRedirect("testing/testingdevfailed.html");
		}
	}

}
