<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width-device-width, initial-scale=1.0"/>
    <link href="${rootPath}/static/css/main.css?ver=002" rel="stylesheet"/>
    <title>READ BOOK</title>
</head>
<body>
<tiles:insertAttribute name="header"/>
<section class="content">
<tiles:insertAttribute name="content"/>
</section>
<tiles:insertAttribute name="footer"/>
</body>
</html>
