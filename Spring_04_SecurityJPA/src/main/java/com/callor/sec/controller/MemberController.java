package com.callor.sec.controller;

import com.callor.sec.models.UserDetailsVO;
import com.callor.sec.service.MemberService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(@Qualifier("memServiceV1")
                                    MemberService memberService) {
        this.memberService = memberService;
    }

    // login form 을 열기위한 URL
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "member/login";
    }


    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String join() {
        return "member/join";
    }


    @RequestMapping(value="/join", method= RequestMethod.POST)
    public String join(UserDetailsVO userVO) {

        memberService.insert(userVO);

        return "/member/join";
    }

    @ResponseBody
    @RequestMapping(value="/idcheck", method=RequestMethod.GET)
    public UserDetails idcheck(String username){

        /**
         * service(dao) findById(username) 으로 조회를 하여
         * 결과를 바로 return 할 수 있다.
         *
         *  이미 데이터가 있으면 회원정보가 return
         *  그렇지 않으면 null 값이 자동으로 return 될 것이다.
         */
//        if(username.equalsIgnoreCase("callor")){
//            // callor 라는 id가 있으면 FAIL
//            return "callor";
//        } else {
//            return null;
//        }
        return memberService.findById(username);
    }
}
