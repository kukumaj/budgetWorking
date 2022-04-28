<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Rysiek
  Date: 28.04.2022
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<body>
</head>
<main>
    <div>Id : ${user.id}</div>
    <div>Area code : ${user.areaCode}</div>
    <div>Phone number : ${user.phoneNumber}</div>
    <div>First Name : ${user.firstName}</div>
    <div>Last Name : ${user.lastName}</div>
<%--    <div>Last Name : ${user.birthDate}</div>--%>
    <jsp:useBean id="date" class="java.util.Date"/>
    <div>Birth Date : <fmt:formatDate value="${user.birthDate}" type="date" pattern="dd-MM-yyyy"/></div>

</main>
</body>
</html>
