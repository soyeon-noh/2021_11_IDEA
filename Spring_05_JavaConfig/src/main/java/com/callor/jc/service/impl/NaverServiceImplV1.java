package com.callor.jc.service.impl;

import com.callor.jc.models.BookVO;
import com.callor.jc.models.NaverRestLayout;
import com.callor.jc.service.NaverService;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service("naverServiceV1")
@PropertySource("classpath:naver.properties")
public class NaverServiceImplV1 extends NaverService {

    @Value("${naver.client_id}")
    private String naver_clinet_id;
    @Value("${naver.client_secret}")
    private String naver_client_secret;

    @Autowired
    private StandardPBEStringEncryptor encryptor;



    // naver open API 에 연결하기
    public String getJsonString(String queryString) throws IOException {

        // java net 의 URL
        // exception처리하는데 throws를 IOException으로 변경함
        URL url = new URL(queryString);
        HttpURLConnection httpCon
                = (HttpURLConnection) url.openConnection();
        httpCon.setRequestMethod("GET");

        log.debug("X-Naver-Client-Id : {}", naver_clinet_id);
        log.debug("X-Naver-Client-Secret : {}", naver_client_secret);


        httpCon.setRequestProperty("X-Naver-Client-Id",
                encryptor.decrypt(naver_clinet_id));
        httpCon.setRequestProperty("X-Naver-Client-Secret",
                encryptor.decrypt(naver_client_secret));


        InputStreamReader is = null;

        // 요청하기
        // naver 야 내가 보낸 요청을 어떻게 할래
        int httpStatusCode = httpCon.getResponseCode();

        // 내가 데이터를 줄테니 준비해!
        if(httpStatusCode == 200){;
                // 정상 : getInputStream을 연결시켜준다
            is = new InputStreamReader(httpCon.getInputStream(),
                    "UTF-8"); // naver에서 전송되는 데이터가 한글이 꺠져와서 부득이하게 넣음
        } else {
            // 비정상 : getErrorStream을 연결시켜준다
            is = new InputStreamReader(httpCon.getErrorStream(),
                    "UTF-8");
        }

        // Buffer
        BufferedReader buffer = new BufferedReader(is);
        StringBuffer stringBuffer = new StringBuffer();
        while(true){
            String reader = buffer.readLine();
            if(reader == null) break;

            stringBuffer.append(reader);
        }
        return stringBuffer.toString();
    }

    /**
     * RestTemplate 를 사용하여 naver 도서정보 가져오기
     *
     */
    @Override
    public List<BookVO> naverList(String queryString) throws URISyntaxException {
        /**
         * VO 클래스를 Wrapping 하여 API 데이터 가져오기
         */
        RestTemplate restTemp = new RestTemplate();
        ResponseEntity<NaverRestLayout> restList = null;

        URI restURI = new URI(queryString);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id",
                encryptor.decrypt(naver_clinet_id));
        headers.set("X-Naver-Client-Secret",
                encryptor.decrypt(naver_client_secret));

        // API 에서 XML, JSON 데이터를 한가지 URL 로 요청하는 경우
        // 수신한 데이터 Type 을 지정해주기
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // 설정된 header 정보를 Http 프로토콜에 담기기
        HttpEntity<String> httpEntity = new HttpEntity<String>("parameters", headers);

        restList = restTemp.exchange(
                restURI,
                HttpMethod.GET,
                httpEntity,
                NaverRestLayout.class);

        return restList.getBody().getItems();
    }
}
