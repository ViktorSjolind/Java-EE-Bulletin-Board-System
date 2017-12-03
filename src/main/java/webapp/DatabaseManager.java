package webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseManager {	
	private String URL = "jdbc:mysql://localhost:3306/data?verifyServerCertificate=false&useSSL=true";
	private String USERNAME = Preferences.getUsername();
	private String PASSWORD = Preferences.getPassword();	
	private Connection connection = null;
	
	private PreparedStatement selectThreads = null;
	private PreparedStatement insertThread = null;
	private PreparedStatement insertPost = null;
	private PreparedStatement selectPosts = null;
	private PreparedStatement selectSpecificThread = null;
	private ResultSet resultSet = null;
	
	public DatabaseManager(){
		try{
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			selectThreads = connection.prepareStatement("SELECT id, content, date FROM thread");
			selectSpecificThread = connection.prepareStatement("SELECT id, content, date FROM thread WHERE thread.id = ?");			
			selectPosts = connection.prepareStatement("SELECT id, content, date FROM post WHERE post.parent_id = ?");			
			insertPost = connection.prepareStatement("insert into post values(0, ?, ?, ?)");
			insertThread = connection.prepareStatement("insert into thread values(0, ?, ?)");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	public void insertPost(String name, String content, int parentID){
		//id, content, date, parent_id
		try{
			//insertPost.setString(1, name);
			insertPost.setString(1, content);
			insertPost.setTimestamp(2, new Timestamp(new Date().getTime()));
			insertPost.setInt(3, parentID);
			insertPost.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}
	
	public void insertThread(String name, String content){
		//id, content, date
		try{
			//insertPost.setString(1, name);
			insertThread.setString(1, content);
			insertThread.setTimestamp(2, new Timestamp(new Date().getTime()));
			insertThread.execute();
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
	
	public List getThreadList(){
		List<Message> result = new ArrayList();
		try{
			resultSet = selectThreads.executeQuery();
			while(resultSet.next()){
				result.add(new Message(resultSet.getInt("id"), resultSet.getString("content"), resultSet.getTimestamp("date")));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List getSpecificThread(int ID){		
		List<Message> result = new ArrayList();
		try{
			selectSpecificThread.setInt(1, ID);			
			//Fetch the OP post
			resultSet = selectSpecificThread.executeQuery();
			while(resultSet.next()){
				result.add(new Message(resultSet.getInt("id"), resultSet.getString("content"), resultSet.getTimestamp("date")));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public List getPostsList(int parentID){
		//reusing Thread class for posts, same DB structure
		List<Message> result = new ArrayList();
		try{
			selectPosts.setInt(1, parentID);			
			resultSet = selectPosts.executeQuery();
			while(resultSet.next()){
				result.add(new Message(resultSet.getInt("id"), resultSet.getString("content"), resultSet.getTimestamp("date")));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	
}