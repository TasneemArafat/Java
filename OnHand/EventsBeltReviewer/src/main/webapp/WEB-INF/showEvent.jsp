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
<div class="container">
	<div class="show">
		<div>
			<h3><c:out value="${Event.name}"></c:out></h3>
			<p>Host: <c:out value="${Event.host.first_name}"></c:out> <c:out value="${Event.host.last_name}"></c:out></p>
			<p>Date: <c:out value="${Event.event_date}"></c:out></p>
			<p>Location: <c:out value="${Event.location}"></c:out>, <c:out value="${Event.eventstate.name}"></c:out></p>
			<p>People who are attending this event: <c:out value="${num}"></c:out></p>
			<br>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Name</th>
						<th>Location</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${Event.users}" var="user">
					<tr>
						<td>${user.first_name} ${user.last_name}</td>
					    <td>${user.location}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<h3>Message Wall</h3>
			<div class="form-control">
			<c:forEach items="${Event.messages}" var="msg">
			<p><c:out value="${msg.user.first_name}"></c:out> says: <c:out value="${msg.message}"></c:out></p>
			</c:forEach>
			</div>
			<br>
			<form:form action="/message" method="post" modelAttribute="mess">
				<form:input type="hidden" value="${Event.id}" path="event"/>
				<form:input type="hidden" value="${user.id}" path="user"/>
			    <p>
			        <form:label path="message" class="form-label">Add Comment: </form:label>
			        <form:errors path="message" class="form-label"/>
			        <form:textarea path="message" class="form-control"/>
			    </p>  
			    <input type="submit" value="Submit"/>
			</form:form>
		</div>
	</div>
</div> 
</body>
</html>