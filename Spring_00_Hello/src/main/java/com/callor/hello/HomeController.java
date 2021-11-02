package com.callor.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String home() {
        return "반갑습니다 나는 IntelliJ IDEA 입니다";
    }
}
