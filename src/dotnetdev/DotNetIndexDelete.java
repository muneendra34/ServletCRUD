package dotnetdev;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DotNetIndexDelete
 */
@WebServlet("/DotNetIndexDelete")
public class DotNetIndexDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		String fn = (String) s.getAttribute("u1");
		fn = fn.toLowerCase();
		
		DotNetActions ja = new DotNetActions();
		int i = ja.goDotNetDelete(fn);
		if( i != 0 )
		{
			response.sendRedirect("dotnet/dotnetuserdelete.html");
		}
	}

}
