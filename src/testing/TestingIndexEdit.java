package testing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestingIndexEdit
 */
@WebServlet("/TestingIndexEdit")
public class TestingIndexEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession s = request.getSession();
		
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title> Software Tester Update page</title>\r\n" + 
				"<link href=\"css/style2.css\" rel=\"stylesheet\">\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<center>\r\n" + 
				"<form action=\"TestingEditServlet\" method=\"post\" >\r\n" + 
				"  <div class=\"container\">\r\n" + 
				"    <h1>Update Software Tester Details :</h1>\r\n" + 
				"    <hr>\r\n" + 
				"    <b>First Name :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>\r\n" + 
				"  	<input type=\"text\" placeholder=\"First Name\" name=\"fname\" value="+s.getAttribute("ud1")+" ><br>\r\n" + 
				"  	<b>Last Name :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>\r\n" + 
				"  	<input type=\"text\" placeholder=\"Last Name\" name=\"lname\" value="+s.getAttribute("ud2")+"><br>\r\n" + 
				"    <b>Password  : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>\r\n" + 
				"    <input type=\"password\" placeholder=\"Enter Password\" name=\"psw\" value="+s.getAttribute("ud3")+"><br>\r\n" + 
				"	<b>Re-Password :&nbsp; </b>\r\n" + 
				"    <input type=\"password\" placeholder=\"Repeat Password\" name=\"psw-repeat\" value="+s.getAttribute("ud4")+"><br>\r\n" + 
				"    <b>Address :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>\r\n" + 
				"  	<input type=\"text\" placeholder=\"Address\" name=\"address\" value="+s.getAttribute("ud5")+"><br>\r\n" + 
				"  	<b>Phone Number:&nbsp;</b>\r\n" + 
				"  	<input type=\"text\" placeholder=\"Phone Number\" name=\"phone\" value="+s.getAttribute("ud6")+"><br>\r\n" + 
				"  	<b>Designation :&nbsp;&nbsp;&nbsp;&nbsp;</b>\r\n" + 
				"  	<input type=\"text\" name=\"desig\" value=\"Software_Tester\"><br>\r\n" + 
				"    <input type=\"submit\" class=\"registerbtn\" value=\"Edit Details\"></form>\r\n" + 
				"    <br>\r\n" + 
				"  	<a href=\"testinglogin.html\">Click here  </a> for Login form.</form>  </div>\r\n" + 
				"<center>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
	}

}
