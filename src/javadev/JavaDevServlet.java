package javadev;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JavaDev
 */
@WebServlet("/JavaDevServlet")
public class JavaDevServlet extends HttpServlet {
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
		JavaDevBean jdb = new JavaDevBean(fn,ln,psw,rpsw,addr,phone,des);
		PrintWriter out = response.getWriter();
		JavaActions ja = new JavaActions();
		try 
		{
			int i = ja.goJavaInsert();
			if( i != 0) 
			{
				response.sendRedirect("java/javalogin.html");
			}
			else
			{
				response.sendRedirect("java/javadevfailed.html");
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		}
		else
		{
			response.sendRedirect("java/javadevfailed.html");
		}
	}

}
