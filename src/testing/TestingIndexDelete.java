package testing;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class TestingIndexDelete
 */
@WebServlet("/TestingIndexDelete")
public class TestingIndexDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		String fn = (String) s.getAttribute("u1");
		fn = fn.toLowerCase();
		
		TestingActions ja = new TestingActions();
		int i = ja.goTestingDelete(fn);
		if( i != 0 )
		{
			response.sendRedirect("testing/testinguserdelete.html");
		}
	}

}
