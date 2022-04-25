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
      <a href="add_users"/>Add User</a> </br></br>
      <section class="summary">
          <c:forEach var="user" items="${requestScope.users}">

                  <div>Area code : ${user.areaCode}</div>
                  <div>Id : ${user.id}</div>
              <a href="delete?id=<c:out value='${user.id}' />">Delete</a>
              <a href="edit?id=<c:out value='${user.id}' />">Edit</a></br></br></br></br>

          </c:forEach>
      </section>
  </main>
</body>
</html>
