<%--
  Created by IntelliJ IDEA.
  User: baekd
  Date: 2024-04-13
  Time: 오전 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>수강신청조회</title>
</head>
<body>
<div class="container">
    <%@ include file="header.jsp"%>
    <h2>수강신청조회</h2>
    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th>년도</th>
            <th>학기</th>
            <th>교과목명</th>
            <th>교과구분</th>
            <th>담당교수</th>
            <th>학점</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="course" items="${courses}" >
            <tr>
                <td> <c:out value="${course.year}"/> </td>
                <td> <c:out value="${course.semester}"/> </td>
                <td> <c:out value="${course.courseName}"/> </td>
                <td> <c:out value="${course.courseCode}"/> </td>
                <td> <c:out value="${course.professor}"/> </td>
                <td> <c:out value="${course.credit}"/> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
