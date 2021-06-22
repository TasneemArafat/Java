<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<div class=container>
<a href="/dashboard">Dashboard</a>
<p>Title: <c:out value="${song.title}"></c:out></p>
<br>
<p>Artist: <c:out value="${song.artist}"></c:out></p>
<br>
<p>Rating(1-10): <c:out value="${song.rating}"></c:out></p>
<br>
<form:form action="/songs/${song.id}" method="post">
	<input type="hidden" name="_method" value="delete">
	<input type="submit" value="delete" class="btn btn-outline-danger"/>
</form:form>
</div>
</body>
</html>