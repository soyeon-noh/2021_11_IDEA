<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<html>
  <head>
    <title>$Title$</title>
    <style>
      *{
        box-sizing: border-box;
        margin: 0;
        padding: 0;
      }
    </style>
    <link href="${rootPath}/static/css/home.css" rel="stylesheet"/>
    <link href="${rootPath}/static/css/headerAndNav.css" rel="stylesheet"/>
  </head>
  <body>
  <%@include file="/WEB-INF/views/headerAndNav.jsp"%>
    <h1>여기는 home 입니다</h1>
  </body>
</html>
