<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<html>
<link href="${rootPath}/static/css/headerAndNav.css" rel="stylesheet"/>
<link href="${rootPath}/static/css/list.css" rel="stylesheet"/>

<body>
<%@ include file="/WEB-INF/views/headerAndNav.jsp" %>
<section>
    <h1>학생정보</h1>
    <table class="list_table">
        <thead>
        <tr>
            <th>학번</th>
            <th>이름</th>
            <th>전공</th>
            <th>학년</th>
            <th>주소</th>
            <th>전화번호</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${STLIST}" var="ST">
                <tr>
                    <td>${ST.st_num}</td>
                    <td>${ST.st_name}</td>
                    <td>${ST.st_dept}</td>
                    <td>${ST.st_grade}</td>
                    <td>${ST.st_address}</td>
                    <td>${ST.st_tel}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
</body>
</html>

