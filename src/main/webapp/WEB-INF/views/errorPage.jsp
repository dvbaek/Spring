<%--
  Created by IntelliJ IDEA.
  User: baekd
  Date: 2024-04-14
  Time: 오후 8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="errorPage.jsp" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <h3>에러가 발생하였습니다.</h3>
    <% exception.printStackTrace(new java.io.PrintWriter(out)); %>
</body>
</html>
