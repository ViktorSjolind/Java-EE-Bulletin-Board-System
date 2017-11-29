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
		DatabaseManager databaseManager = new DatabaseManager();
		int parentID = Integer.parseInt(request.getParameter("id"));
		List<Message> postsList = databaseManager.getSpecificThread(parentID);
		postsList.addAll(databaseManager.getPostsList(parentID));	
		
		request.setAttribute("postsList", postsList);		
		request.setAttribute("id", parentID);	
		request.getRequestDispatcher("/WEB-INF/views/thread.jsp").forward(request, response);
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		DatabaseManager databaseManager = new DatabaseManager();
		String name = request.getParameter("inputName");
		String content = request.getParameter("inputContent");
		int parentID = Integer.parseInt(request.getParameter("id"));	
		
		databaseManager.insertPost(name, content, parentID);		
		doGet(request, response);
	}
	
	
}