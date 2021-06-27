<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><c:out value="${product.name}"></c:out></h1>
<h3>Categories: </h3>
<ul>
<c:forEach items="${product.categories}" var="cat">
<li><c:out value="${cat.name}"></c:out></li>
</c:forEach>
</ul>
<form action="/products/${product.id}" method="post">
	<select name="category_id">
		<c:forEach items="${Categories}" var="category">
			<option value="${category.id}">${category.name}</option>
		</c:forEach>
	</select>
	<input type="submit" value="add"> 
</form>
</body>
</html>