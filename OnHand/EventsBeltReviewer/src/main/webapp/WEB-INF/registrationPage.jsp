<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Welcome!</h1>
    <p><c:out value="${error}" /></p>
    <p><form:errors path="user.*"/></p>
	<div class="regLog">
		<div>
		    <h3>Register</h3>
		    <form:form method="POST" action="/registration" modelAttribute="user">
		        <p>
		            <form:label path="first_name" class="form-label">First Name: </form:label>
		            <form:input type="text" path="first_name" class="form-control"/>
		        </p>
		        <p>
		            <form:label path="last_name" class="form-label">Last Name: </form:label>
		            <form:input type="text" path="last_name" class="form-control" />
		        </p>
		                <p>
		            <form:label path="email" class="form-label">Email: </form:label>
		            <form:input type="email" path="email" class="form-control"/>
		        </p>
		        <p>
		            <form:label path="location" class="form-label">Location: </form:label>
		            <form:input type="text" path="location" class="form-control"/>
		            <form:label path="state" class="form-label">State: </form:label>
		            <form:select path="state" class="form-select">
		            <c:forEach items="${states}" var="state">
		            <form:option value="${state.id}">${state.name}</form:option>
		            </c:forEach>
		            </form:select>
		        </p>
		        <p>
		            <form:label path="password" class="form-label">Password:</form:label>
		            <form:password path="password" class="form-control"/>
		        </p>
		        <p>
		            <form:label path="passwordConfirmation" class="form-label">Password Confirmation:</form:label>
		            <form:password path="passwordConfirmation" class="form-control"/>
		        </p>
		        <input type="submit" value="Register" class="btn btn-warning"/>
		    	</form:form>
		    </div>
	    	<div>
			    <h3>Login</h3>
			    <form method="post" action="/login" modelAttribute="user">
			        <p>
			            <label for="email" class="form-label">Email</label>
			            <input type="text" id="email" name="email" class="form-control"/>
			        </p>
			        <p>
			            <label for="password" class="form-label">Password</label>
			            <input type="password" id="password" name="password" class="form-control"/>
			        </p>
			        <input type="submit" value="Login" class="btn btn-success"/>
			    </form>
		    </div>
	</div>   
</div>
</body>
</html>