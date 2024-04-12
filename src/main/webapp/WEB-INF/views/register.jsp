<%--
  Created by IntelliJ IDEA.
  User: baekd
  Date: 2024-04-13
  Time: 오전 6:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>수강신청하기</title>
</head>
<body>
<div class="container py-4 row align-items-md-stretch">
    <sf:form method="post" action="${pageContext.request.contextPath}/doRegister" modelAttribute="course">
        <div class="mb-3 row">
            <label class="col-sm-2">교과코드</label>
            <div class="col-sm-3">
                <sf:input class="form-control" type="text" path="courseCode" />
                <sf:errors path="courseCode" cssClass="error text-danger"/>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2">교과목명</label>
            <div class="col-sm-3">
                <sf:input class="form-control" type="text" path="courseName" />
                <sf:errors path="courseName" cssClass="error text-danger"/>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2">교과구분</label>
            <div class="col-sm-3">
                <sf:input class="form-control" type="text" path="classification" />
                <sf:errors path="classification" cssClass="error text-danger"/>

            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2">담당교수</label>
            <div class="col-sm-3">
                <sf:input class="form-control" type="text" path="professor" />
                <sf:errors path="professor" cssClass="error text-danger"/>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2">학점</label>
            <div class="col-sm-3">
                <sf:input class="form-control" type="text" path="credit" />
                <sf:errors path="credit" cssClass="error text-danger"/>
            </div>
        </div>
        <div class="mb-3 row">
            <div class="col-sm-offset-2 col-sm-10 ">
                <input type="submit" class="btn btn-secondary" value="신청하기" />
            </div>
        </div>
    </sf:form>
</div>
</body>
</html>
