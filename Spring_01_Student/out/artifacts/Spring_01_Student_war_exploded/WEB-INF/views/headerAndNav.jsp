<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
<%--    <style>--%>

<%--      *{--%>
<%--        box-sizing: border-box;--%>
<%--        margin: 0;--%>
<%--        padding: 0;--%>
<%--      }--%>

<%--      header.main_header{--%>
<%--        display: flex;--%>

<%--        height: 15vh;--%>
<%--        background-color: #398d71;--%>
<%--        color: white;--%>

<%--        justify-content: center;--%>
<%--        align-items: center;--%>
<%--      }--%>

<%--      nav.main_nav{--%>
<%--        flex-direction: row;--%>
<%--        background-color: #113a2c;--%>
<%--        color: white;--%>
<%--      }--%>

<%--      nav.main_nav ul {--%>
<%--        display: flex;--%>
<%--        list-style: none;--%>
<%--      }--%>

<%--      nav.main_nav ul li {--%>
<%--        padding: 0.8rem;--%>
<%--        cursor: pointer;--%>
<%--      }--%>

<%--      nav.main_nav ul li:hover {--%>
<%--        background-color: #3a1117;--%>
<%--      }--%>

<%--      #home {--%>
<%--       margin-left : 1rem;--%>
<%--      }--%>

<%--      #login{--%>
<%--        margin-left: auto;--%>
<%--        margin-right: 1rem;--%>
<%--      }--%>
<%--    </style>--%>
  </head>
  <body>
    <header class="main_header">
      <h1>고려 고교 학사관리 시스템 2021 v1</h1>
    </header>
    <nav class="main_nav">
      <ul>
        <li id="home">Home</li>
        <li id="list">학생정보</li>
        <li id="score">성적알림표</li>
        <li id="login">로그인</li>
      </ul>
    </nav>
  </body>
<script>
  let nav = document.querySelector("nav.main_nav")
  nav.addEventListener("click", (e)=>{
    let nav_id = e.target.id
    if(nav_id == "home"){
      location.href = "/student"
    } else if (nav_id == "list"){
      location.href = "/student/student"
    } else if (nav_id == "score"){
      location.href = "/student/score"
    } else if (nav_id == "login"){
      location.href = "/student/login"
    }
  })
</script>
</html>
