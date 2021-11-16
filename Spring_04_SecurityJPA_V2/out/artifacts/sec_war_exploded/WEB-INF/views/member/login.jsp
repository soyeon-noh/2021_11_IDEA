<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%-- 공식문서는 아래와 같이 쓰라고하는데 이러면 인식못한다 -->
<%--<script src="${rootPath}/webjars/jquery/3.6.0/jquery.min.js"></script>--%>
<%-- dist 를 꼭 넣어준다 --%>
<script src="${rootPath}/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
<link href="${rootPath}/static/css/login.css?ver=2021-11-16-001" rel="stylesheet">

<script>
    $(function(){
        $("button.btn_join").on("click", function(){
            location.href= "${rootPath}/member/join"
        })
    })
</script>

<form:form action="${rootPath}/login" cssClass="login_form">
    <fieldset>
        <h2>로그인</h2>
        <c:if test="${param.error != null}">
            <h3>아이디와 비밀번호를 확인해주세요</h3>
            ${ERROR_MSG == null ? "로그인을 하세요" : ERROR_MSG}
        </c:if>
        <input
                placeholder="사용자 ID"
                name="username">
        <input
                placeholder="비밀번호"
                type="password"
                name="password">
        <button class="btn btn_login">로그인</button>
        <button class="btn btn_join" type="button">회원가입</button>
    </fieldset>
    <h2>${AUTHOR}</h2>
</form:form>

<%--<script>--%>
<%--    const btn_join = document.querySelector("button.join")--%>

<%--    btn_join.addEventListener("click", ()=>{--%>
<%--        location.href = "${rootPath}/member/join"--%>
<%--    })--%>
<%--</script>--%>