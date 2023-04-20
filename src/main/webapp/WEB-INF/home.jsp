<%--
  Created by IntelliJ IDEA.
  User: Abdallah
  Date: 13/04/2023
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<c:import url="header.jsp"></c:import>

<h1>Welcome ${identifier} to CHI-FOU-MI game !!!</h1>
</br>
<nav>
    <ul>
        <li>
            <a href="http://localhost:8088/game">go to the game</a>
        </li>
        <li>
            <a href="http://localhost:8088/users">Go to user lists</a>
        </li>
        <li>
            <a href="http://localhost:8088/history">Go to history game</a>
        </li>
    </ul>
</nav>
</body>
</html>
