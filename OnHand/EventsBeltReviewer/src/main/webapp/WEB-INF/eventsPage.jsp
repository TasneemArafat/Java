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
	<header>
		<h3>Welcome, <c:out value="${user.first_name}" /></h3>
		<a href="/logout">Logout</a>
	</header>
	<main>
	<p>Here are some of the events in your state:</p>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action / Status</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${Events}" var="eve">
		        <tr>
		        	<td><a href="/events/${eve.id}">${eve.name}</a></td>
		            <td>${eve.event_date}</td>
		            <td>${eve.location}</td>
		            <th>${eve.host.first_name}</th>
		            <c:choose>
		            <c:when test="${eve.host.id == user.id}">
		            <th><a class="btn btn-primary" href="/events/${eve.id}/edit">Edit</a> 
		            <form:form method="POST" action="/events/${eve.id}" modelAttribute="event">
		            <input type="hidden" name="_method" value = "DELETE"/>
		            <input type="submit" value="Delete" class="btn btn-danger"/>
					</form:form>
		            </th>
		            </c:when>
		            <c:when test="${eve.users.contains(user)}">
		            <th>joining <a href="/cancelEvent/${eve.id}">Cancel</a></th>
		            </c:when>
		            <c:otherwise>
		            <th><a href="/joinEvent/${eve.id}">join</a></th>
		            </c:otherwise>
		            </c:choose>
		        </tr>
		    </c:forEach>
		    </tbody>
		</table>
		<br>
		<p>Here are some of the events in other states:</p>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>State</th>
					<th>Host</th>
					<th>Action / Status</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${outStatesEvents}" var="event">
		        <tr>
		            <td><a href="/events/${event.id}">${event.name}</a></td>
		            <td>${event.event_date}</td>
		            <td>${event.location}</td>
		            <td>${event.eventstate.name}</td>
		            <th>${event.host.first_name}</th>
		            <c:choose>
		            <c:when test="${event.host.id == user.id}">
		            <th><a class="btn btn-primary"  href="/events/${event.id}/edit">Edit</a> 
		            <form:form method="POST" action="/events/${event.id}" modelAttribute="event">
		            <input type="hidden" name="_method" value = "DELETE"/>
		            <input type="submit" value="Delete" class="btn btn-danger"/>
					</form:form>
					</th>
		            </c:when>
		            <c:when test="${event.users.contains(user)}">
		            <th>joining <a href="/cancelEvent/${event.id}">Cancel</a></th>
		            </c:when>
		            <c:otherwise>
		            <th><a href="/joinEvent/${event.id}">join</a></th>
		            </c:otherwise>
		            </c:choose>
		        </tr>
		     </c:forEach>
		     </tbody>
		     </table>
		<br>
		<h1>Create an Event</h1>
	    <p><c:out value="${error}" /></p> 
	    <form:form method="POST" action="/events" modelAttribute="event">
	    	<form:input type="hidden" value="${user.id}" path="host"/>
	        <p>
	            <form:label class="form-label" path="name">Name: </form:label>
	            <form:errors class="form-label" path="name"/>
	            <form:input class="form-control" type="text" path="name"/>
	        </p>
	        <p>
	            <form:label class="form-label" path="event_date">Date: </form:label>
	            <form:errors class="form-label" path="event_date"/>
	            <form:input class="form-control" type="date" path="event_date"/>
	        </p>
	        <p>
	            <form:label class="form-label" path="location">Location: </form:label>
	            <form:errors class="form-label" path="location"/>
	            <form:input class="form-control" type="text" path="location"/>
	            <form:label class="form-label" path="eventstate">State: </form:label>
	            <form:select class="form-select" path="eventstate">
	            <c:forEach items="${states}" var="state">
	            <form:option value="${state.id}">${state.name}</form:option>
	            </c:forEach>
            </form:select>
	        </p>
	        <input class="btn btn-success" type="submit" value="Add"/>
	    </form:form>
	</main>
</div>
</body>
</html>