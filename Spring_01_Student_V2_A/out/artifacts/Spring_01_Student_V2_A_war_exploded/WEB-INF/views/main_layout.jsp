<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <%-- meta 정보 셋팅하기 --%>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%-- jQuery 가져오기 --%>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link href="${rootPath}/static/css/main.css?ver=2021-11-08-001"
          rel="stylesheet"/>
    <title>학사관리</title>
</head>
<body>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="nav"/>
<tiles:insertAttribute name="content"/>
<tiles:insertAttribute name="footer"/>
</body>
</html>
