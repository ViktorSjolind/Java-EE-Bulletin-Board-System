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

<form action="/thread?id=${id }" method="post" name="postForm">	
	<input type="text" name ="inputName" placeholder="Name"/>
	<br>
	<textarea rows="10" cols="80" name="inputContent" placeholder="Comment"></textarea>
	<br>	
	<input type="submit" value="Post"/>
</form>
parent: ${id }

</body>
</html>