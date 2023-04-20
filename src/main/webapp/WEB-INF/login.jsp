<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Abdallah
  Date: 13/04/2023
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<c:import url="header.jsp"></c:import>
<main class="p-3 mb-2 bg-light text-dark">

    <form action="login" method="post">
      <div class="form-group">
        <label for="exampleInputEmail1">Id</label>
        <input name="identifier" type="text" class="form-control w-25 p-3" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Id">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input name="password" type="password" class="form-control w-25 p-3" id="exampleInputPassword1" placeholder="Password">
      </div>
      <button type="submit" class="btn btn-secondary btn-sm">Log in</button>
    </form>
    <form action="signup">
      <button type="submit" class="btn btn-secondary btn-sm">Sign up</button>
    </form>
    <c:if test="${error != null}">
      <div class="alert alert-danger w-25 p-3" role="alert">
          ${error}
      </div>
    </c:if>

</main>
</body>
</html>
