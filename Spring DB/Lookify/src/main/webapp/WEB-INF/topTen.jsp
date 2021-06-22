<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
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
<h1>Top Ten Songs:</h1>
<ul>
<c:forEach items="${topTen}" var="song">
<li><c:out value="${song.rating}"></c:out>-<a href="/songs/${song.id}"><c:out value="${song.title}"></c:out></a>-<c:out value="${song.artist}"></c:out></li>
</c:forEach>
</ul>
</div>
</body>
</html>