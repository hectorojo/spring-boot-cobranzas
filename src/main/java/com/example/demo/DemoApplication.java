package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@SpringBootApplication
@EnableOAuth2Sso
public class DemoApplication extends WebSecurityConfigurerAdapter {
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .antMatcher("/**")
      .authorizeRequests()
        .antMatchers("/", "/user","/login**", "/webjars/**", "/error**")
        .permitAll()
      .anyRequest().
    authenticated().and().logout().logoutSuccessUrl("/").permitAll().and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
  }
  
 
  }

 
