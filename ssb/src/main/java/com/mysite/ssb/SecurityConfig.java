package com.mysite.ssb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;


//https://wikidocs.net/162150
@Configuration //스프링 환경설정 파일임을 의미하는 어노테이션
@EnableWebSecurity //모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만드는 어노테이션 
								  //@EnableWebSecurity 애너테이션을 사용하면 내부적으로 SpringSecurityFilterChain이 동작하여 URL 필터가 적용된다.
public class SecurityConfig {

	//스프링 시큐리티의 세부 설정은 SecurityFilterChain 빈을 생성하여 설정할 수 있다. 
	//다음 문장은 모든 인증되지 않은 요청을 허락한다는 의미이다. 따라서 로그인을 하지 않더라도 모든 페이지에 접근할 수 있다.
	//이렇게 스프링 시큐리티 설정 파일을 구성하면 이제 질문 목록, 질문 답변 등의 기능을 이전과 동일하게 사용할 수 있다.
	
	//CSRF란?
	//CSRF(cross site request forgery)는 웹 사이트 취약점 공격을 방지를 위해 사용하는 기술이다. 
	//스프링 시큐리티가 CSRF 토큰 값을 세션을 통해 발행하고 웹 페이지에서는 폼 전송시에 해당 토큰을 함께 전송하여 
	//실제 웹 페이지에서 작성된 데이터가 전달되는지를 검증하는 기술이다.
	
	//스프링 시큐리티에 의해 위와 같은 CSRF 토큰이 자동으로 생성된다. 즉, 스프링 시큐리티는 이렇게 발행한 CSRF 토큰의 값이 정확한지 검증하는 과정을 거친다. 
	//(만약 CSRF 값이 없거나 해커가 임의의 CSRF 값을 강제로 만들어 전송하는 악의적인 URL 요청은 스프링 시큐리티에 의해 블록킹 될 것이다.)

	
	//그런데 H2 콘솔은 이와 같은 CSRF 토큰을 발행하는 기능이 없기 때문에 위와 같은 403 오류가 발생하는 것이다.
	//스프링 시큐리티가 CSRF 처리시 H2 콘솔은 예외로 처리할 수 있도록 다음과 같이 설정 파일을 수정하자.
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().requestMatchers(
                new AntPathRequestMatcher("/**")).permitAll()
        		.and().csrf().ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))
        		.and().headers().addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN));           
	    		
        		//and() http 객체의 설정을 이어서 할 수 있게 하는 메서드이다.
	    		//csrf().ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")) - /h2-console/로 시작하는 URL은 CSRF 검증을 하지 않는다는 설정이다.
	        
        	return http.build();
    }
	
	@Bean
	PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder(); 
	}
		
	
}
