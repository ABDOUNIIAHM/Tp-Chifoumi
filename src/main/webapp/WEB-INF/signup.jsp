<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Abdallah
  Date: 14/04/2023
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<c:import url="header.jsp"></c:import>
<main class="p-3 mb-2 bg-light text-dark">


    <div class="form-group">
        <label for="exampleInputEmail1">Name</label>
        <input name="name" type="text" class="form-control w-25 p-3" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Your name">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Identifier</label>
        <input name="id" type="text" class="form-control w-25 p-3" id="" placeholder="Your id">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input name="mdps" type="password" class="form-control w-25 p-3" id="exampleInputPassword1" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-secondary btn-sm">Sign Up</button>

    <c:if test="${error != null}">
        <div class="alert alert-danger w-25 p-3" role="alert">
                ${error}
        </div>
    </c:if>
</main>

</body>
</html>
