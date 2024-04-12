<%--
  Created by IntelliJ IDEA.
  User: baekd
  Date: 2024-04-13
  Time: 오전 4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>학사정보시스템</title>
</head>
<body>
<div class="container py-4">
    <header class="d-flex justify-content-between align-items-center py-3 border-bottom">
        <a href="${pageContext.request.contextPath}/" class="d-flex align-items-center text-dark text-decoration-none">
            <svg  width="32" height="32" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
                <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z"/>
                <path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z"/>
            </svg>
            <span class="fs-4">학사 정보 시스템</span>
        </a>

        <%--    <a href="./home.jsp" class="d-flex align-items-center text-dark text-decoration-none">--%>
        <%--      <button type="button" class="btn btn-secondary">Login</button>--%>
        <%--    </a>--%>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <a href="javascript:document.getElementById('logout').submit()">Logout</a>
        </c:if>
        <form id="logout" action="<c:url value="/logout" />" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </header>
</div>
<div class="row align-items-md-stretch   text-center">
    <div class="col-md-4">
        <div class="h-100 p-2">
            <h5><b>학년별 이수 학점 조회</b></h5>
            <p>Inquiry of credits completed by grade
            <p><a href="${pageContext.request.contextPath}/earnedCredits" class="btn btn-secondary" role="button"> 조회하기 &raquo;</a>
        </div>
    </div>
    <div class="col-md-4">
        <div class="h-100 p-2">
            <h5><b>수강신청하기</b></h5>
            <p>Register for a course
            <p><a href="${pageContext.request.contextPath}/register" class="btn btn-secondary" role="button"> 신청하기 &raquo;</a>
        </div>
    </div>
    <div class="col-md-4">
        <div class="h-100 p-2">
            <h5><b>수강신청 조회</b></h5>
            <p>Inquiry for course regisration
            <p><a href="${pageContext.request.contextPath}/registeredCourses" class="btn btn-secondary" role="button"> 조회하기 &raquo;</a>
        </div>
    </div>
</div>
</body>
</html>
