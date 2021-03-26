package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity  //Spring Security 설정들을 활성화시켜줌
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()   //h2-console 화면을 사용하기 위해 해당 옵션들을 disable함

                .and()
                .authorizeRequests() //URL별 권한 관리를 설정하는 옵션의 시작점, authorizeRequests 가 선언 되어야지만 antMatchers 옵션을 사용할 수 있음
                .antMatchers("/", "css/**", "images", "/js/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated() //설정 이외 나머지 URL

                .and()
                .logout().logoutSuccessUrl("/")

                .and()
                .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }
}
