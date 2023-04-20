<%--
  Created by IntelliJ IDEA.
  User: Abdallah
  Date: 13/04/2023
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Results</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<c:import url="header.jsp"></c:import>
<main class="p-3 mb-2 bg-light text-dark">
  <h3> Pick a choice</h3>
  <form method="post" action="game">
    <div class="btn-group" role="group" aria-label="Basic example">
      <button name="choice" class="btn btn-secondary" value="PIERRE">PIERRE</button>
      <button name="choice" class="btn btn-secondary" value="FEUILLE">FEUILLE</button>
      <button name="choice" class="btn btn-secondary" value="CISEAUX">CISEAUX</button>
    </div>
  </form>
  <section>
    <p>User choice : ${gameService.game.userChoice}</p>
    <p>Server choice : ${gameService.game.serverChoice}</p>
    <p>${gameService.game.winner}</p>
  </section>
  <section>
    <p>Round number : ${gameService.game.round}</p>
  </section>
  </br>
  <table class="table table-dark w-25 p-3">
    <th>
      <tr>
        <td>Game ID</td>
        <td>Round game </td>
        <td>server Choice</td>
        <td>user Choice </td>
        <td>Winner </td>
        <td>is Draw </td>
      </tr>
    </th>
    <tbody>
    <c:forEach items="${games}" var="game">
      <tr>
        <td>${game.gameId}</td>
        <td>${game.round}</td>
        <td>${game.serverChoice}</td>
        <td>${game.userChoice}</td>
        <td>${game.winner}</td>
        <td>${game.isDraw}</td>
        <td>${game.round}</td>
      </tr>
    </c:forEach>
    </tbody>
</main>

</table>
</body>
</html>
