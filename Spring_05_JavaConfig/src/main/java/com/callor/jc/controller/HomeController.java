package com.callor.jc.controller;

import com.callor.jc.models.BookVO;
import com.callor.jc.repository.BookDao;
import com.callor.jc.service.impl.NaverServiceImplV1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Slf4j
@Controller
public class HomeController {

    private final NaverServiceImplV1 naverService;
    private final BookDao bookDao;

    public HomeController(NaverServiceImplV1 naverService, BookDao bookDao) {
        this.naverService = naverService;
        this.bookDao = bookDao;
    }

    @RequestMapping(value="/",
            method = RequestMethod.GET,
            produces =  "text/html;charset=UTF-8") // ResponseBody 한글깨짐 막을 수 있음 (개별설정)
    public String home() {
        return "home";
    }

    @ResponseBody
    @RequestMapping(value="/",
            method=RequestMethod.POST,
            // responseBody로 화면을 보여줄 때 한글이 깨지는 것을 방지하는 코드
//            produces = "text/html;charset=UTF-8")
            produces = "application/json;charset=UTF-8")
    public List<BookVO> home(String search) throws IOException, URISyntaxException {

        String queryString = naverService.queryString(search);
        String jsonString = naverService.getJsonString(queryString);

        List<BookVO> bookList = naverService.naverList(queryString);

        log.debug("솔직히 이건 나와야함");
        return bookList;
    }
}
