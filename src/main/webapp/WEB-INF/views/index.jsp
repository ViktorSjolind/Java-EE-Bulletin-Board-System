<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/assets/styles/style.css" type="text/css">
<title>Chat</title>
</head>
<body>

<h1 id="logoText">Bulletin Board System</h1>

<ul id="threadsList">
    <c:forEach items="${threadsList}" var="item">
        <li class="threadBox">
        <c:set var="threadURL">
        	<c:url value="thread">
        	<c:param name="id" value="${item.id }"/>
        	</c:url>
        </c:set>        
        
        <div class="threadBoxHeader"> <a href="${threadURL }"> Id: ${item.id}</a> | Time: <span class="threadBoxDate">${item.date}</span> </div>        
        <p class="threadBoxContent">${item.content}</p>        
        </li>
        <br/> <hr/> <br/>
    </c:forEach>
</ul>



</body>
</html>