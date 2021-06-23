<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h1>New Student</h1>
<form:form action="/contacts/new" method="post" modelAttribute="contact">
	<form:select path="student">
		<c:forEach items="${stu}" var="stdnt">
			<form:option value="${stdnt.id}">${stdnt.firstName} ${stdnt.lastName}</form:option>
		</c:forEach>
	</form:select>
    <p>
        <form:label path="address" class="form-label">Address: </form:label>
        <form:errors path="address" class="form-label"/>
        <form:input path="address" class="form-control" />
    </p>
    <p>
        <form:label path="city" class="form-label">City: </form:label>
        <form:errors path="city" class="form-label"/>
        <form:input path="city" class="form-control"/>
    </p>
    <p>
        <form:label path="State" class="form-label">State: </form:label>
        <form:errors path="State" class="form-label"/>
        <form:input path="State" class="form-control"/>
    </p>  
    <input type="submit" class="btn btn-outline-success" value="Create"/>
</form:form>    
</div>
</body>
</html>