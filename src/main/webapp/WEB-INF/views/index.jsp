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


<%while(posts.next()){ %>
<p><%= posts.getInt("id") %>
<%= posts.getString("content")%></p>
<% }%>
<br>



</body>
</html>