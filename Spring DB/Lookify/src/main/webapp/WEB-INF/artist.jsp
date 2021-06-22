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
<header>
<form action="/search">
	<label>Songs by artist: <c:out value="${artist}"></c:out></label>
	<input type="text" name="search">
	<input type="submit" value="New Search"/>
</form>
<a href="/dashboard">Dashboard</a>
</header>
<table class="table table-striped">
	<thead>
		<tr>
			<th>Name</th>
			<th>rating</th>
			<th>actions</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${listOfSongsFor}" var="song">
        <tr>
            <td><a href="/songs/${song.id}"><c:out value="${song.title}"></c:out></a></td>
            <td><c:out value="${song.rating}"></c:out></td>
            <td>
            <form:form action="/songs/${song.id}" method="post">
    		<input type="hidden" name="_method" value="delete">
    		<input type="submit" value="delete" class="btn btn-outline-danger"/>
    		</form:form>
			</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>