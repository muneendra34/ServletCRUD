package dotnetdev;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DotNetDevServlet
 */
@WebServlet("/DotNetDevServlet")
public class DotNetDevServlet extends HttpServlet {
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
		DotNetDevBean jdb = new DotNetDevBean(fn,ln,psw,rpsw,addr,phone,des);
		PrintWriter out = response.getWriter();
		DotNetActions ja = new DotNetActions();
		try 
		{
			int i = ja.goDotNetInsert();
			if( i != 0) 
			{
				response.sendRedirect("dotnet/dotnetlogin.html");
			}
			else
			{
				response.sendRedirect("dotnet/dotnetdevfailed.html");
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		}
		else
		{
			response.sendRedirect("dotnet/dotnetdevfailed.html");
		}
	}


}
