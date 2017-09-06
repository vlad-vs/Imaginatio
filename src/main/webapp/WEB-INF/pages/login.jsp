<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
         language="java" %>
<html>
<head>
    <meta charset="utf-8">

    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/MainStyle.css">

    <title>Login</title>

</head>
<body>
<div class="wrapper">
    <form name='form_login' login-processing-url="/j_spring_security_check" method='POST'>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <table>
            <tr>
                <td>User:</td>
                <td><input type="text" name='user_login'></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password_login'/></td>
            </tr>
            <tr>
                <td><input name="submit" type="submit" value="submit"/></td>
            </tr>
        </table>
    </form>
</div>
</div>

</body>
</html>
