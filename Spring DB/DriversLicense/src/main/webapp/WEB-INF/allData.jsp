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
<p style="color:red">Java es una lingua Mierda</p>
<table class="table table-striped">
	<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>License</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${allPersons}" var="person">
        <tr>
        	<td>${person.id}</td>
            <td><a href="/persons/${person.id}">${person.firstName} ${person.lastName}</a></td>
            <td><c:out value="${person.license.number}"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>