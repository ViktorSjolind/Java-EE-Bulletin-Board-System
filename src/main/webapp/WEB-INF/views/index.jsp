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
	<a id=threadFormLink href="#" onclick="toggle_visibility('threadForm');">Create thread</a>	
	<div id="threadForm">
		<form action="/" method="post" name="threadForm">	
			<!--   <input type="text" name ="inputName" placeholder="Name"/> -->
			<br>
			<textarea rows="10" cols="80" name="inputContent" placeholder="New thread"></textarea>
			<br>	
			<input type="submit" value="Post"/>
		</form>		
	</div>
    <c:forEach items="${threadsList}" var="item">
        <li class="threadBox">
        <c:set var="threadURL">
        	<c:url value="thread">
        	<c:param name="id" value="${item.id }"/>
        	</c:url>
        </c:set>        
        
        <div class="threadBoxHeader"> <a href="${threadURL }"> Id: ${item.id}</a> | Time: <span class="threadBoxDate">${item.date}</span> <a href="${threadURL }"> Reply </a></div>        
        <p class="threadBoxContent">${item.content}</p>   
        <br/> <hr/> <br/>
            
        </li>
       
    </c:forEach>
</ul>

<script type="text/javascript">

    function toggle_visibility(id) {
       var e = document.getElementById(id);
       if(e.style.display == 'block')
          e.style.display = 'none';
       else
          e.style.display = 'block';
    }

</script>

</body>
</html>