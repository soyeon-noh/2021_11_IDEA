<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section>
    <div>
        <input placeholder="도서번호"/>
        <input placeholder="도서명"/>
    </div>
    <div class="three">
        <input type="date" placeholder="읽은날짜"/>
        <input type="time" placeholder="읽기시작"/>
        <input type="time" placeholder="읽기마침"/>
    </div>
    <div><input class="title" placeholder="제목"/></div>
    <div><textarea placeholder="내용" rows="20" style="resize: none;"></textarea></div>
    <div class="button_box">
        <button class="btn_list">리스트보기</button>
        <button class="btn_rewrite">다시작성</button>
        <button class="btn_save">저장</button>
    </div>
</section>
