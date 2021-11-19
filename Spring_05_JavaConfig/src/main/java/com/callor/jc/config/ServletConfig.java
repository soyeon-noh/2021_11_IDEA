package com.callor.jc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * servlet-context.xml 파일을 대신할 Java Config 클래스
 *
 * @Configuration : 이 파일은 context.xml 을 대신할 파일이라는 뜻
 * @EnableWebMvc : 이제 Spring MVC 프로젝트의 servlet 이 시작된다.
 *      servlet-context.xml, dispatcher-servlet.xml 등을 대신한 파일
 *
 * @ComponentScan : 위 2개를 써주고 원하는 곳을 스캔하도록 적어주면된다.
 *                  다수 패지키지를 스캔하고싶으면 배열형식으로 작성
 * ex) @ComponentScan(basePackages = {"com.callor.jc"})
 * ex) @ComponentScan(basePackages = {"com.callor.jc.controller", "com.callor.jc.service"})
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "com.callor.jc.controller",
        "com.callor.jc.service",
        "com.callor.jc.config.beans"
})
public class ServletConfig implements WebMvcConfigurer {

    // ResourceHandler 설정
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/static/**")
                .addResourceLocations("/static/");

        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    /**
     * method 에 @Bean Annotation 을 부착하면
     * 이 method 는 반드시 객체를 생성해서 return 해야 한다.
     *
     * Spring 컨테이너는 프로젝트가 시작되는 시점에
     * 이 method 를 자동으로(강제로) 실행하고
     * 생성된 객체를 Container 에 보관하여
     * 다른 곳에서 필요한 경우 주입하도록 준비해둔다.
     *
     */
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver
                = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(2); // resolver가 여러개일 경우 순서를 지정해줘야한다.
        // tiles 와 같이쓸때 tiels는 1번 여기는 1번보다 큰값으로 작성해주면 된다.
        return viewResolver;
    }
}