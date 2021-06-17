<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="/survey" method="POST">
        <label for="name">Your Name: </label>
        <input type="text" name="name"><br>
        <label for="location">Dojo Location: </label>
        <select name="location">
            <option value="palestine">Palestine</option>
            <option value="USA">USA</option>
            <option value="japan">Japan</option>
        </select><br>
        <label for="language">Favourite Language: </label>
        <select name="language">
            <option value="python">Python</option>
            <option value="java">Java</option>
            <option value="mern">MERN</option>
        </select><br>
        <label for="comment">Comments (Optional): </label><br>
        <textarea name="comment"></textarea><br>
        <input type="submit" name="submit" value="Button">
    </form>
</body>
</html>