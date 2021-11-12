package com.callor.sec.service.auth;

import com.callor.sec.models.UserDetailsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * security 에서 login 서비스를 수행하는 방법이 다양하다.
 *
 * DB와 연동하여 로그인을 수행하는 비교적 쉬운 방법으로
 * UserDetailService 를 상속받아 클래스를 만들고 수행한다.
 *
 * ======================
 * UserDetailService uds = new LoginService()
 * uds.loadUserByUsername(username)
 * spring이 이렇게 호출했을 것이다
 */
@Slf4j
@Service("loginService")
public class LoginService implements UserDetailsService {

    private final String encPassword = "$2a$04$F0J1Z8VMVF.SWgHHzw2I6OFjIcZllFCCUe4u4yFmMdNldPTTZDTDO";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /**
         * 1. dao 에서 사용자 정보 가져오기
         * username 으로 member table 에서
         * findById(username) 등을 수행하여
         * User 정보를 가져온다.
         */
        UserDetailsVO userVO = UserDetailsVO.builder()
                .username("callor")
//                .password("{noop}1234")
                .password(encPassword)
                .isAccountNonExpired(true)
                .isEnabled(true)
                .isCredentialsNonExpired(true)
                .isAccountNonLocked(true)
                .build();

        /**
         * 2.dao 에서 받은 사용자 정보가 없으면
         * 즉, username 에 저장된 사용자이름이 DB에 없으면
         *   강제로 exception 을 발생시켜
         *   security 에게 알려준다.
         *
         * 이제 security가 파악해서
         * login form에 error 메시지를 전송할 것이다
         */
        if(userVO == null){
            log.debug("{} username 없음", username);

            throw new UsernameNotFoundException(username+ "사용자 없음");
        }

        // =============================================
        // security 에 내장된 코드를 가상으로 적어본다.
        //try {
        //    UserDetails vo = loadUserByUsername("callor");
        //    // 비밀번호를 검사하는 코드가 내장되어 있을 것이다.
        //} catch(UsernameNotFoundException e) {
        //    // redirect "/member/login?error=xxxx";
        //}
        // =============================================

       return userVO;
    }
}
