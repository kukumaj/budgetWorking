<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script type="text/javascript">
        function matchpass(){
            var area = document.forms["userForm"]["area"];
            var phoneNumber = document.forms["userForm"]["phoneNumber"];
            var firstName = document.forms["userForm"]["firstName"];
            var lastName = document.forms["userForm"]["lastName"];
            var birthDate = document.forms["userForm"]["birthDate"];
            var password = document.forms["userForm"]["password"];
            var confirmPassword = document.forms["userForm"]["confirmPassword"];

            if (area.value === "")
            {
                window.alert("Please enter area");
                area.focus();
                return false;
            }

            if (phoneNumber.value === "")
            {
                window.alert("Please enter phone number");
                phoneNumber.focus();
                return false;
            }

            if (firstName.value === "")
            {
                window.alert("Please enter your first name.");
                firstName.focus();
                return false;
            }
            if (lastName.value === "")
            {
                window.alert("Please enter your last name.");
                lastName.focus();
                return false;
            }
            if (birthDate.value === "")
            {
                window.alert("Please enter your birth date.");
                birthDate.focus();
                return false;
            }

            if (confirmPassword.value !== password.value)
            {
                window.alert("Passwords must match.");
                confirmPassword.focus();
                return false;
            }

            if (password.value === "")
            {
                alert("Please enter your password.");
                password.focus();
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
<main>
    <c:if test="${user != null}">
        Edit User
        ${pageContext.request.contextPath}
    </c:if>
    <c:if test="${user == null}">
        Add New User
        ${pageContext.request.contextPath}
    </c:if>

    <c:if test="${user == null}">
        <form name="userForm" action="${pageContext.request.contextPath}/add_users" method="post" onsubmit="return matchpass()">
    </c:if>
    <c:if test="${user != null}">
        <form name="userForm" action="${pageContext.request.contextPath}/edit" method="post" onsubmit="return matchpass()">
    </c:if>


        <c:if test="${user != null}">
            <h2>id =  ${user.id}</h2>
            <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
        </c:if>
        <fieldset>
            <legend>Add new position</legend>
            <label class="keyboard-inputs">
                Area code*:
                <input name="area" value="<c:out value='${user.areaCode}' />" placeholder="for example 123">
            </label></br>
            <label class="keyboard-inputs">
                Phone number*:
                <input name="phoneNumber" value="${user.phoneNumber}" placeholder="for example 1555555555">
            </label></br>
            <label class="keyboard-inputs">
                Firs name*:
                <input name="firstName" value="${user.firstName}"  placeholder="for example Tom">
            </label></br>
            <label class="keyboard-inputs">
                Last name*:
                <input name="lastName" value="${user.lastName}"  placeholder="for example Jerry">
            </label></br>
            <label class="keyboard-inputs">
                Birth date*:
                <input type="date" name="birthDate" value="${user.birthDate}">
            </label></br>
            <label class="keyboard-inputs">
                Password*:
                <input type="password" name="password" value="${user.password}"  placeholder="your password">
            </label></br>
            <label class="keyboard-inputs">
                Confirm Password*:
                <input type="password" name="confirmPassword" placeholder="confirm password">
            </label></br>
            <button>Save</button>
        </fieldset>
    </form>
</main>
</body>
</html>
