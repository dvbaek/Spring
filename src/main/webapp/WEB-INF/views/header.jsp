<%--
  Created by IntelliJ IDEA.
  User: baekd
  Date: 2024-04-14
  Time: 오후 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container py-4">
    <header class="d-flex justify-content-between align-items-center py-3 border-bottom">
        <a href="${pageContext.request.contextPath}/" class="d-flex align-items-center text-dark text-decoration-none">
            <svg  width="32" height="32" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
                <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z"/>
                <path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z"/>
            </svg>
            <span class="fs-4">학사 정보 시스템</span>
        </a>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
<%--            <form id="logout" action="<c:url value="/logout" />" method="post">--%>
            <form id="logout" action="${pageContext.request.contextPath}/logout" method="post">
                <button type="submit" class="btn btn-secondary">Logout</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </c:if>
    </header>
</div>