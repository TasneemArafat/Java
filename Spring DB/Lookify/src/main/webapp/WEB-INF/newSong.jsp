<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<form:form action="/songs/new" method="post" modelAttribute="song">
    <p>
        <form:label  path="title" class="form-label">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title" class="form-control"/>
    </p>
    <p>
        <form:label path="artist" class="form-label">Artist</form:label>
        <form:errors path="artist"/>
        <form:input path="artist" class="form-control"/>
    </p>
    <p>
        <form:label path="rating" class="form-label">Rating (1-10)</form:label>
        <form:errors path="rating"/>
        <form:input path="rating" type="number" class="form-control"/>
    </p>
    <input type="submit" value="Add Song" class="btn btn-outline-success"/>
</form:form>
</div>
</body>
</html>