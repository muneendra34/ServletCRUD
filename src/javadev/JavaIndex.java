package javadev;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class JavaIndex
 */
@WebServlet("/JavaIndex")
public class JavaIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		String fn = request.getParameter("fname");
		fn = fn.toLowerCase();
		String psw = request.getParameter("psw");
		psw = psw.toLowerCase();
		s.setAttribute("u1",fn);
		PrintWriter out = response.getWriter();
		Checks ck = new Checks();
		boolean b = ck.goJavaLoginCheck(fn,psw);
		if( b == true)
		{
			JavaActions ja = new JavaActions();
			ResultSet rs = null;
			rs = ja.goGetDetails(fn);
			String[] ss = new String[20]; 
			
			int i = 0;
			int j = 1;
			try {	
				while(rs.next())
				{
					for(i=0,j=1; j<=7; i++,j++)
					{
						ss[i] = rs.getString(j);
						String temp =   ss[i].substring(0, 1).toUpperCase() + ss[i].substring(1);
						ss[i] = temp;
						
					}
				}
				
				s.setAttribute("ud1",ss[0]); 
				s.setAttribute("ud2",ss[1]);
				s.setAttribute("ud3",ss[2]);
				s.setAttribute("ud4",ss[3]);
				s.setAttribute("ud5",ss[4]);
				s.setAttribute("ud6",ss[5]);
				s.setAttribute("ud7",ss[6]);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			out.println("<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"<head>\r\n" + 
					"  <title>:: Welcome ::</title>\r\n" + 
					"  <meta charset=\"utf-8\">\r\n" + 
					"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"  <link rel=\"stylesheet\" href=\"css/1bootstrap.min.css\">\r\n" + 
					"  <script src=\"js/1jquery.min.js\"></script>\r\n" + 
					"  <script src=\"js/1bootstrap.min.js\"></script>\r\n" + 
					"</head>\r\n" + 
					"<body> \r\n" + 
					" \r\n" + 
					"<div class=\"container\">\r\n" + 
					"  <h2>Welcome "+ss[0].toUpperCase()+"</h2>\r\n" + 
					"  <div class=\"panel panel-warning\">\r\n" + 
					"   <div class=\"panel-heading\">User Details :</div> <div class=\"panel-body\" align=\"center\">");
					out.println("<div align=\"left\">"+
					"<b><h5>First Name  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :&nbsp;&nbsp;&nbsp;&nbsp;"+ss[0]+"</h5></b><br>"+
					"<b><h5>Last Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp; "+ss[1]+"</h5></b><br>"+
					"<b><h5>Address&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :&nbsp;&nbsp;&nbsp;&nbsp; "+ss[4]+"</h5></b><br>"+
					"<b><h5>Phone Number&nbsp;&nbsp;&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;"+ss[5]+"</h5></b><br>"+
					"<b><h5>Designation&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :&nbsp;&nbsp;&nbsp; "+ss[6]+"</h5></b><br>"
					);
					out.println(" <div class=\"btn-group\">"+
					"<form action=\"JavaIndexEdit\" method=post><input type=\"submit\" class=\"btn btn-info\" value=\"Update\"></form>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
					"<form action=\"JavaIndexDelete\" method=post onsubmit=\"return confirm('Do you really want to delete the user?');\"><input type=\"submit\" class=\"btn btn-danger\" value=\"Delete\"></form>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
					"<form action=\"JavaIndexLogout\" method=post><input type=\"submit\" class=\"btn btn-warning\" value=\"Logout\"></form></div></div>");
					out.println("</div>\r\n  </div>\r\n" + 
					"</div>\r\n" + 
					"\r\n");
					out.println("</body>\r\n" + 
					"</html>\r\n" + 
					"");
		}
		else
		{
			response.sendRedirect("java/javaloginerror.html");
		}
			
		
	}

}
