<%--
  Created by IntelliJ IDEA.
  User: baekd
  Date: 2024-04-13
  Time: 오전 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Please sign in(Custom Login Form)</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
</head>
<body>
<div class="container">
    <!--<form class="form-signin" method="post" action="/helloSpringMVC/login">-->
    <form class="form-signin" method="post" action="<c:url value="/login" />">
        <h2 class="form-signin-heading">Please sign in</h2>

        <c:if test="${not empty errorMsg}">
            <div style="color: #ff0000;"><h3>${errorMsg}</h3></div>
        </c:if>

        <c:if test="${not empty logoutMsg}">
            <div style="color: #0000ff;" > <h3> ${logoutMsg} </h3></div>
        </c:if>

        <p>
            <label for="username" class="sr-only">Username</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        </p>
        <p>
            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
        <!--<input name="_csrf" type="hidden" value="df0bfc5c-9011-4790-9813-be520aeb053d" />-->
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</div>
</body>

</html>
