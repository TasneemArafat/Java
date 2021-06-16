<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="/code" method="POST">
<br>
<br>
<p><c:out value="${error}"/></p>
<br>
<label>What is the Code?</label><br>
<input type="text" name="code"><br>
<button>Try Code</button>
</form>
</center>
</body>
</html>