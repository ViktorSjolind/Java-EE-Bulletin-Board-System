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
	private String URL = "jdbc:mysql://localhost:3306/data";
	private String USERNAME = "root";
	private String PASSWORD = "t00rSQL";	
	private Connection connection = null;
	
	private PreparedStatement selectThread = null;
	private PreparedStatement insertThread = null;
	private ResultSet resultSet = null;
	
	public DatabaseManager(){
		try{
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			selectThread = connection.prepareStatement("SELECT id, content, date FROM thread");
			insertThread = connection.prepareStatement("insert into thread values(0, ?, ?)");
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
		List<Thread> result = new ArrayList();
		try{
			resultSet = selectThread.executeQuery();
			while(resultSet.next()){
				result.add(new Thread(resultSet.getInt("id"), resultSet.getString("content"), resultSet.getTimestamp("date")));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}