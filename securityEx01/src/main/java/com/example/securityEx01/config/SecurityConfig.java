package com.example.securityEx01.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests((auth) -> auth
				.requestMatchers("/members/**").hasAnyRole("ADMIN", "USER")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().permitAll()
				);
		//http.csrf(AbstractHttpConfigurer::disable);
		http.csrf((auth) -> auth.disable());
		
		/*
		http.formLogin((auth) -> auth
				.loginPage("/login") // 로그인 폼 지정 - 쓰지 않으면 Spring 제공 로그인 폼 사용
				.loginProcessingUrl("/loginProc") // 로그인 폼 지정 후 폼 정보 보내는 곳 - 이후 스르핑부트에서 알아서 해줌
				.defaultSuccessUrl("/members/membersPage") // anyRequest에 해당 - 인증 된 상태이므로 문제 없음.
				.failureUrl("/fail")// requestMatchers() permitAll() 설정 필요
				.permitAll()
				);
		*/
		
		http.httpBasic(Customizer.withDefaults());
		
		http.logout((auth) -> auth
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout") // 로그아웃 성공 후 리디렉션 URL
                .invalidateHttpSession(true) // 세션 무효화
                .deleteCookies("JSESSIONID") // 쿠키 삭제
                .permitAll()
				);
		
		
		return http.build();
	}
	
//	@Bean
//	public WebSecurityCustomizer webSecurityCustomizer() {
//		return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//	}
	
	
}
