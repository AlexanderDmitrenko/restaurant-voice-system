<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>--%>
<html>
<head>
    <title>Dish list</title>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <hr/>
    <h2>Dishes</h2>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Date</th>
            <th>Name</th>
            <th>Price</th>
        </tr>
        </thead>
        <c:forEach items="${dishes}" var="dish">
            <jsp:useBean id="dish" type="com.dmitrenko.restaurant.model.Dish"/>
            <tr>
                <td>${dish.date}</td>
                <td>${dish.name}</td>
                <td>${dish.price}</td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
