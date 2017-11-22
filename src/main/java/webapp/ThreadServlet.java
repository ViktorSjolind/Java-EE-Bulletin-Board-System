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




@WebServlet(urlPatterns = "/thread")
public class ThreadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//DatabaseManager databaseManager = new DatabaseManager();
		//List<Thread> threadsList = databaseManager.getThreadList();
		String content = "blabla op sucks";
		request.setAttribute("content", content);
		
		//for(Thread thread: threadsList){
		//	System.out.println(thread.getId() + " " + thread.getContent() + " " + thread.getDate());
		//}

		request.getRequestDispatcher("/WEB-INF/views/thread.jsp").forward(request, response);
		
	}

}