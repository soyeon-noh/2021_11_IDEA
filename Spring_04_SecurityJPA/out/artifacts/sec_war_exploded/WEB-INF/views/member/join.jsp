<%-- jquery 사용 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<script src="${rootPath}/webjars/jquery/dist/jquery.min.js"></script>
<script>
    $(function () {

        // 입력박스에서 tab을 누르거나 마우스를 다른 곳으로 클릭했을 때
        // lost focus
        $("input#username").on("blur", function () {
            // ID 중복검사
            // ${rootPath}/member/idcheck=username=callor
            // 라고 적어도 되지만 jquery를 사용하여 더 편하게 한 것임
            $.ajax({
                url: "${rootPath}/member/idcheck",
                data: {username:$(this).val()} // 현재 input내부에 있는 값을 url 서버로 보낸다
                // this는 현재 이벤트가 실행되고 있는 요소
                // 주의 : this는 화살표함수에서는 문제가 있을 수 있음, function() 사용 권장
            })
                .done(function (result) {
                    if (result) {
                        alert("이미 사용중인 ID 입니다")
                        $("div.input_error").text(
                            "이미 사용중인 ID 입니다"
                        )
                        .css("color", "red")
                        $(this).focus()
                    } else {
                        $("div.input_error").text(
                            "사용가능한 ID 입니다"
                        )
                        .css("color", "blue")
                        $("#password").focus()
                    }
                })
        })

        $("button.btn_join_ok").on("click", function () {
            const username = $("#username")
            const password = $("#password")
            const re_password = $("#re_password")
            if (username.val() === "") {
                alert("사용자 이름은 반드시 입력하세요")
                username.focus()
                return false
            }
            if (password.val() === "") {
                alert("비밀번호는 반드시 입력하세요")
                password.focus()
                return false
            }
            if (re_password.val() === "") {
                alert("비밀번호를 한번 더 입력해 주세요")
                re_password.focus()
                return false
            }
            if (password.val() !== re_password.val()) {
                alert("비밀번호와 비밀번호 확인이 일치하지 않습니다")
                password.val("")
                re_password.val("")
                password.focus()
                return false
            }
            if (confirm("회원가입을 신청할까요?")) {
                $("form.join").submit()
            }
        })
    })
</script>

<style>
    div.input_error{

        font-weight: bold;
    }
</style>

<form:form cssClass="join" method="POST">
    <div>
    <input name="username" id="username" placeholder="사용자 이름"/>
    </div>
    <div class="input_error">

    </div>
    <div>
    <input name="password" id="password" placeholder="비밀번호"/>
    </div>
    <div>
    <input name="re_password" id="re_password" placeholder="비밀번호 확인"/>
    </div>
    <div>
    <button class="btn btn_join_ok" type="button">회원 가입 신청</button>
    </div>
</form:form>
