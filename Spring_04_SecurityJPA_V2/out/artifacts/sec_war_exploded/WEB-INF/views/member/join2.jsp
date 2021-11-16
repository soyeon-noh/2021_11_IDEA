<!-- javascript 사용 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>

<script>
    $(function(){
        $("button.btn_join_ok").on("click",function (){
            const username = $("#username")
            const password = $("#password")
            const re_password = $("#re_password")
            if(username.val() === "") {
                alert("사용자 이름은 반드시 입력하세요")
                username.focus()
                return false
            }
            if(password.val() === "") {
                alert("비밀번호는 반드시 입력하세요")
                password.focus()
                return false
            }
            if(re_password.val() === "") {
                alert("비밀번호를 한번 더 입력해 주세요")
                re_password.focus()
                return false
            }
            if(password.val() !== re_password.val()) {
                alert("비밀번호와 비밀번호 확인이 일치하지 않습니다")
                password.val("")
                re_password.val("")
                password.focus()
                return false
            }
            $("form.join").submit()
        })
    })
</script>

<style>
form.join_form {
    display: flex;
    flex-direction: column;
    max-width: 800px;
    min-width: 400px;
    margin: 30px auto;
}

form.join_form div {
    text-align: center;
    margin: 1rem 0;
}

form.join_form div label,
form.join_form div input{
    display: inline-block;
    padding: 0.3rem;
}

form.join_form div label{
    width: 35%;
    text-align: left;
}

form.join_form div input{
    width: 60%;
}


</style>
<form:form action="${rootPath}/join" cssClass="join_form">
    <div>
    <label>사용자 이름</label>
    <input name="username" placeholder="사용자 이름"/>
    </div>
    <div>
    <label>비밀번호</label>
    <input name="password" placeholder="비밀번호"/>
    </div>
    <div>
    <label>비밀번호 확인</label>
    <input name="passwordCheck" placeholder="비밀번호 확인"/>
    </div>
    <div>
    <label>Email</label>
    <input name="email" placeholder="Email"/>
    </div>
    <div>
    <button type="button" class="join">회원가입 신청</button>
    </div>
</form:form>
<script>
    const btn_join = document.querySelector("button.join")

    const username = document.querySelector("input[name='username']")
    const password = document.querySelector("input[name='password']")
    const passwordCheck = document.querySelector("input[name='passwordCheck']")
    const email = document.querySelector("input[name='email']")

    btn_join.addEventListener("click", ()=>{

        if(!username.value){
            alert("사용자 이름을 입력해주세요")
            username.focus()
            return false
        }
        if(!password.value){
            alert("비밀번호를 입력해주세요")
            password.focus()
            return false
        }
        if(!passwordCheck.value){
            alert("비밀번호 확인을 입력해주세요")
            passwordCheck.focus()
            return false
        }else if(passwordCheck.value !== password.value){
            alert("비밀번호와 일치하지 않습니다")
            passwordCheck.focus()
            return false
        }
        if(!email.value){
            alert("이메일을 입력해주세요")
            email.focus()
            return false
        }
        alert("로그인 성공!")
        location.href = `${rootPath}/member/login`
    })
</script>
