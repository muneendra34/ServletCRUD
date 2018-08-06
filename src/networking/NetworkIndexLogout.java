package networking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NetworkIndexLogout
 */
@WebServlet("/NetworkIndexLogout")
public class NetworkIndexLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		 
        HttpSession s = request.getSession(false);  
        s.invalidate();
        response.sendRedirect("network/networklogin.html");
	}

}
