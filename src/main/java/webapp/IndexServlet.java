package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = "/index.do")
public class IndexServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Thread thread = new Thread();
		List<String> threadsList = thread.getThreadList();
		request.setAttribute("threadsList", threadsList);
		
		for(String str: threadsList){
			System.out.println(str);
		}
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
		
	}

}