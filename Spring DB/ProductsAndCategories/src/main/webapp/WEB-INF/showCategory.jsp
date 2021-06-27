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
<h1><c:out value="${category.name}"></c:out></h1>
<h3>Products: </h3>
<ul>
<c:forEach items="${category.products}" var="pro">
<li><c:out value="${pro.name}"></c:out></li>
</c:forEach>
</ul>
<form action="/categories/${category.id}" method="post">
	<select name="product_id">
		<c:forEach items="${Products}" var="product">
			<option value="${product.id}">${product.name}</option>
		</c:forEach>
	</select>
	<input type="submit" value="add"> 
</form>
</body>
</html>