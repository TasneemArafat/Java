<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
.container {
	margin: auto 8%;
	text-align:center;
}
</style>
</head>
<body>
<div class="container">
<h1>New License</h1>
<form:form action="/licenses/new" method="post" modelAttribute="license">
	<form:select path="person">
		<c:forEach items="${AllPersons}" var="per">
			<form:option value="${per.id}">${per.firstName} ${per.lastName}</form:option>
		</c:forEach>
	</form:select>
    <p>
        <form:label path="State" class="form-label">State: </form:label>
        <form:errors path="State" class="form-label"/>
        <form:input path="State" class="form-control"/>
    </p>
    <p>
        <form:label path="expirationDate" class="form-label">Exp. Date: </form:label>
        <form:errors path="expirationDate" class="form-label"/>
        <form:input type="date" path="expirationDate" class="form-control"/>
    </p>  
    <input type="submit" value="Create"/>
</form:form> 
</div>
</body>
</html>