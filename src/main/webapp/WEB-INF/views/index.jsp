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


<ul>
    <c:forEach items="${threadsList}" var="item">
        <li>${item}</li>
    </c:forEach>
</ul>



</body>
</html>