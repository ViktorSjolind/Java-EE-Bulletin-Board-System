<%@ page import="java.sql.*" %>
<%@ page import="java.util.Date" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/assets/styles/style.css" type="text/css">
<title>Chat</title>
</head>
<body>



<%!
public class Post{
	String URL = "jdbc:mysql://localhost:3306/data";
	String USERNAME = "root";
	String PASSWORD = "t00rSQL";
	
	Connection connection = null;
	PreparedStatement selectPost = null;
	PreparedStatement selectPost2 = null;
	PreparedStatement insertPost = null;
	ResultSet resultSet = null;
	
	public Post(){
		try{
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			selectPost = connection.prepareStatement("SELECT id, content FROM message");
			selectPost2 = connection.prepareStatement("select * from message where id = 2 ");
			insertPost = connection.prepareStatement("insert into message values(0, ?, ?)");
		}catch(SQLException e){
			e.printStackTrace();
		}		
	}
	
	public ResultSet getPosts(){
		try{
			resultSet = selectPost.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}	
		return resultSet;
	}
	
	public int setPosts(String content, Timestamp timeStamp){
		int result = 0;
		
		try{
			insertPost.setString(1, content);
			insertPost.setTimestamp(2, timeStamp);
			result = insertPost.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		
		return result;
	}
}
%>

<%
Post post = new Post();
ResultSet posts = post.getPosts();
Date date = new Date();
Timestamp timeStamp = new Timestamp(date.getTime());
System.out.println("Time: " + timeStamp);
%>
<%while(posts.next()){ %>
<p><%= posts.getInt("id") %>
<%= posts.getString("content")%></p>
<% }%>
<br>

<p>Updated database</p>
<% 
post = new Post();
post.setPosts("5th message", timeStamp); 
posts = post.getPosts();
%>

<%while(posts.next()){ %>
<p><%= posts.getInt("id") %>
<%= posts.getString("content")%></p>
<% }%>


</body>
</html>