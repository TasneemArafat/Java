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
        Your Gold: <c:out value="${score}"></c:out>
        <div class="container">
            <div>
                <h4>Farm</h4>
                <p>(earns 10-20 golds)</p>
                <form action="/process_money" method="post">
                    <input type="hidden" name="gold" value="farm">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>
            <div>
                <h4>Cave</h4>
                <p>(earns 5-10 golds)</p>
                <form action="/process_money" method="post">
                    <input type="hidden" name="gold" value="cave">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>
            <div>
                <h4>House</h4>
                <p>(earns 2-5 golds)</p>
                <form action="/process_money" method="post">
                    <input type="hidden" name="gold" value="house">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>
            <div>
                <h4>Casino</h4>
                <p>(earns/takes 0-50 golds)</p>
                <form action="/process_money" method="post">
                    <input type="hidden" name="gold" value="casino">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>
        </div>
        <p>Activities</p>
        <ul>
        <c:forEach items="${activities}" var="item">    
        <li style="color:green;">${item}<br></li>
        </c:forEach>
        </ul>

        
</body>
</html>