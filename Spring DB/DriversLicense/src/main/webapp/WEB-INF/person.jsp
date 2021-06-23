<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
<h1><c:out value="${person.firstName} ${person.lastName}"></c:out></h1>
<p>License Number: <c:out value="${person.license.number}"></c:out></p>
<p>State: <c:out value="${person.license.state}"></c:out></p>
<p>Expiration Date: <c:out value="${person.license.expirationDate}"></c:out></p>
</div>
</body>
</html>