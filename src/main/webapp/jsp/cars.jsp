<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>ListOfCars</title>
</head>
<body>
<c:forEach var="cars" items="${cars}">
    ${cars.number}   |   ${cars.client.name}   |
    <c:forEach var="regions" items="${cars.regions}">
            ${regions.name}  |
        </c:forEach>
        <br>
    <br>
</c:forEach>
</body>
</html>