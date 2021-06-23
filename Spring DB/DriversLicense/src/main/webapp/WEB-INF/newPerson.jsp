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
<!-- CSS only -->
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
<h1>New Person</h1>
<form:form action="/persons/new" method="post" modelAttribute="person">
    <p>
        <form:label path="firstName" class="form-label">First Name: </form:label>
        <form:errors path="firstName" class="form-label"/>
        <form:input path="firstName" class="form-control"/>
    </p>
    <p>
        <form:label path="lastName" class="form-label">Last Name: </form:label>
        <form:errors path="lastName" class="form-label"/>
        <form:input path="lastName" class="form-control"/>
    </p>  
    <input type="submit" value="Create"/>
</form:form> 
</div>
</body>
</html>