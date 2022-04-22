<%--
  Created by IntelliJ IDEA.
  User: Rysiek
  Date: 22.04.2022
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<main>
    <h1>Add User</h1>
    <form action="${pageContext.request.contextPath}/add_users" method="post">
        <fieldset>
            <legend>Add new position</legend>
            <label class="keyboard-inputs">
                Area code:
                <input name="area" placeholder="for example 123">
            </label></br>
            <label class="keyboard-inputs">
                Phone number:
                <input name="phoneNumber"   placeholder="for example 1555555555">
            </label></br>
            <label class="keyboard-inputs">
                Firs name:
                <input name="firstName"  placeholder="for example Tom">
            </label></br>
            <label class="keyboard-inputs">
                Last name:
                <input name="last name"   placeholder="for example Jerry">
            </label></br>
            <label class="keyboard-inputs">
                Birth day:
                <input name="birth date"   placeholder="for example 13-05-2005">
            </label></br>
            <label class="keyboard-inputs">
                Password:
                <input name="password"   placeholder="for example passswwword">
            </label></br>
            <button>Zapisz</button>
        </fieldset>
    </form>
</main>
</body>
</html>
