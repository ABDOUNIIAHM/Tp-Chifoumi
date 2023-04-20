<%--
  Created by IntelliJ IDEA.
  User: Abdallah
  Date: 17/04/2023
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<c:import url="header.jsp"></c:import>
<main class="p-3 mb-2 bg-light text-dark">
<h2>List of users</h2>
<table class = "table table-dark w-25 p-3">
    <th>
        <tr>
            <td>User ID</td>
            <td>User name</td>
            <td>User Identifier</td>
        </tr>
    </th>
    <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.userId}</td>
                <td>${user.name}</td>
                <td>${user.id}</td>
                <td><form action="users" method="post">
                    <button type="submit" name="delete-user" class="btn btn-primary btn-sm btn btn-light" value=${user.userId}>Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</main>
</body>
</html>