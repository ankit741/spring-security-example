package com.example.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
  public static final String LOGIN_URL = "/login";
  public static final String LOGOUT_URL = "/logout";
  public static final String LOGIN_FAIL_URL = LOGIN_URL + "?error";
  public static final String DEFAULT_SUCCESS_URL = "/home";
  public static final String USERNAME = "username";
  public static final String PASSWORD = "password";
  public static final String[] ENDPOINTS_WHITELIST = {
      "/css/**",
      "/",
      "/login",
      "/home"
  };

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests(request ->
        request.antMatchers(ENDPOINTS_WHITELIST).permitAll()
            .anyRequest().authenticated())
        .csrf().disable()
        .formLogin(form -> form
            .loginPage(LOGIN_URL)
            .loginProcessingUrl(LOGIN_URL)
            .failureUrl(LOGIN_FAIL_URL)
            .usernameParameter(USERNAME)
            .passwordParameter(PASSWORD)
            .defaultSuccessUrl(DEFAULT_SUCCESS_URL));
    return http.build();
  }

}
