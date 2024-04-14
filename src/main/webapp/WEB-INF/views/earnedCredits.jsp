<%--
  Created by IntelliJ IDEA.
  User: baekd
  Date: 2024-04-13
  Time: 오전 4:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>이수학점 조회</title>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="container">
    <h2>Courses</h2>
    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th>년도</th>
            <th>학기</th>
            <th>취득학점</th>
            <th>상세보기</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="earnedCredit" items="${earnedCredits}" >
            <tr>
                <td> <c:out value="${earnedCredit[0]}"/> </td>
                <td> <c:out value="${earnedCredit[1]}"/> </td>
                <td> <c:out value="${earnedCredit[2]}"/> </td>
                <td> <a href="details?year=${earnedCredit[0]}&semester=${earnedCredit[1]}">상세보기</a> </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr class="table-success font-weight-bold">
            <th>총계</th>
            <td></td>
            <td>${totalCredits}</td>
            <td></td>
        </tr>
        </tfoot>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
