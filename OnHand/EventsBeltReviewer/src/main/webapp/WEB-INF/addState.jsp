<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
</head>
<body>
<h1>Add State</h1>
    <p><c:out value="${error}" /></p> 
    <form:form method="POST" action="/state" modelAttribute="state">
        <p>
            <form:label path="name">State Name: </form:label>
            <form:input type="text" path="name"/>
        </p>
        <input type="submit" value="Add"/>
    </form:form>
</body>
</html>