<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container edit">
<h3>${event.name}</h3>
	<p><c:out value="${error}" /></p> 
	    <form:form method="POST" action="/events/${event.id}/edit" modelAttribute="event">
	    <input type ="hidden" name="_method" value = "PUT">
	    <form:input type="hidden" value="${user.id}" path="host"/>
	<p>
	    <form:label path="name">Name: </form:label>
	    <form:errors path="name"/>
	    <form:input type="text" path="name"/>
	</p>
	<p>
	    <form:label path="event_date">Date: </form:label>
	    <form:errors path="event_date"/>
	    <form:input type="date" path="event_date"/>
	</p>
	<p>
	    <form:label path="location">Location: </form:label>
	    <form:errors path="location"/>
	    <form:input type="text" path="location"/>
	    <form:select path="eventstate">
	    	<c:forEach items="${states}" var="state">
	        	<form:option value="${state.id}">${state.name}</form:option>
	        </c:forEach>
        </form:select>
	</p>
	<input type="submit" value="Edit"/>
	</form:form>
</div>	
</body>
</html>