package com.callor.jc.service;

import com.callor.jc.models.BookVO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;
/**
 * abstract(추상) 클래스
 * 일반 클래스와 인터페이스의 기능을 결합한 클래스
 * 인터페이스 처럼 구현되지 않은 프로토 타입의 method를 가지면서
 * 일부는 자체적으로 구현된 method 도 포함하는 클래스
 *
 * 인터페이스
 * 클래스를 만들기 위한 설계도 역할
 * method 의 프로토 타입만 있고 실제 구현된 코드는 없다.
 *
 * 내부에있는 method 중
 * 이곳에서 작성할 것은 그냥 냅두고
 * interface처럼 상속받은 클래스에서 작성하게 할 것은 abstract를 넣어준다.
 */

public abstract class NaverService<T> {

    private final String NAVER_BOOK_URL
            = "https://openapi.naver.com/v1/search/book.json";

    // 필수적으로 생성할 method
    public String queryString(String search) throws UnsupportedEncodingException {
        String  searchUTF8 = URLEncoder.encode(search, "UTF-8");
        StringBuilder queryURL = new StringBuilder();
        queryURL.append(NAVER_BOOK_URL);
        queryURL.append(String.format("?query=%s",searchUTF8));
        return queryURL.toString();
    }

    // 선택적으로 사용할 method
    // queryStirng을 이용하여  JsonString을 만들고
    public abstract String getJsonString(String queyrString) throws IOException;
    // queryString을 이용하여 naverBookList를 만든다
    public abstract List<BookVO> naverList(String queryString) throws URISyntaxException;
}
