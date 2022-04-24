<%--
  Created by IntelliJ IDEA.
  User: Rysiek
  Date: 22.04.2022
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Users</title>
</head>
<body>
  <main>
    <h1>Users List</h1>
      <section class="summary">
          <p>Users: ${requestScope.users}</p>
          <c:forEach var="user" items="${requestScope.users}">
                  <div>${user.areaCode}</div> </br>
          </c:forEach>
      </section>
  </main>
</body>
</html>
