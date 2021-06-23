<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
.container{
margin:auto 8%;
text-align:center;
}
</style>
</head>
<body>
<div class="container">
<h1>All Students</h1>
<table class="table">
    <thead>
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Address</th>
            <th>City</th>
            <th>State</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${students}" var="student">
        <tr>
            <td><c:out value="${student.firstName} ${student.lastName}"/></td>
            <td><c:out value="${student.age}"/></td>
            <td><c:out value="${student.contact.address}"/></td>
            <td><c:out value="${student.contact.city}"/></td>
            <td><c:out value="${student.contact.state}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
