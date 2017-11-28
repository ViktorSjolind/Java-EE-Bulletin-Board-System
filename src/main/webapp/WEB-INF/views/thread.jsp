<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thread</title>
</head>
<body>


<c:forEach items="${postsList}" var="item">
	<li class="postBox">         
	<div class="postBoxHeader"> Id: ${item.id}| Time: <span class="postBoxDate">${item.date}</span> </div>        
	<p class="postBoxContent">${item.content}</p>        
	</li>
	<br/> <hr/> <br/>
</c:forEach>



</body>
</html>