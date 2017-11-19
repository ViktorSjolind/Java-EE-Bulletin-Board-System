package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

public class Thread {	
	private String URL = "jdbc:mysql://localhost:3306/data";
	private String USERNAME = "root";
	private String PASSWORD = "t00rSQL";	
	private Connection connection = null;
	
	private PreparedStatement selectThread = null;
	private PreparedStatement insertThread = null;
	private ResultSet resultSet = null;
	
	public Thread(){
		try{
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			selectThread = connection.prepareStatement("SELECT id, content FROM message");
			insertThread = connection.prepareStatement("insert into message values(0, ?, ?)");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public int setPosts(String content, Timestamp timeStamp){
		int result = 0;		
		try{
			insertThread.setString(1, content);
			insertThread.setTimestamp(2, new Timestamp(new Date().getTime()));
			result = insertThread.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}		
		return result;
	}
	
	public ResultSet getThreadSet(){
		try{
			resultSet = selectThread.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}	
		return resultSet;
	}
	
	
}