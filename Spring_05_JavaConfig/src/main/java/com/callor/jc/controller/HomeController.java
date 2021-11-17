package com.callor.jc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value="/",
            method = RequestMethod.GET,
            produces =  "text/html;charset=UTF-8") // ResponseBody 한글깨짐 막을 수 있음 (개별설정)
    public String home() {
        return "home";
    }

}
