package com.callor.sec.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated();
        http.formLogin();
        /**
         * spring Security 에서 form 으로 데이터를 전송할 때
         * 보통 POST 로 전송하는데
         * POST 로 전송할 때는 반드시 _csrf.token 값을
         * 데이터에 포함하여 전송해야한다.
         *
         * form 을 만들 때, JSP, thymeleaf 등의 taglibs 등을 사용하면
         * 자동으로 _csrf.token 을 form 에 포함시키는 코드를 함들어준다(기본값)
         *
         * 그런데 최근  spring security 정책이이
         * https( Hyper Text Transfer protocol Sec) 가 적용된 곳에서는
         * 정상적으로 _csrf.token 을 form 에 추가를 한다
         *
         * 그런데 http 로 되어 있는 곳에는 정상적으로 추가하지 않는다.
         *
         * http 로 테스트를 하는 경우에는 아래 속성을 추가해 주어야한다.
         * (나중에 배포할땐 당연히 뺴야함)
        */
        // 말그대로 http여도 넘어가달라는 뜻!
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("callor")
                .password("{noop}1234")
                .roles("ADMIN");
    }

}
