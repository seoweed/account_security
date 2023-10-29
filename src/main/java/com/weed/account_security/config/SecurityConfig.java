package com.weed.account_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                        .antMatchers("/public/**").permitAll()
                        .antMatchers("/user/**", "/").authenticated()
                        .anyRequest().permitAll();
//                    .antMatchers("/login", "/register").permitAll()
//                    .anyRequest().authenticated();
//                .antMatchers("/").authenticated()
//                .anyRequest().permitAll();
        httpSecurity
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/api/login")
                    .defaultSuccessUrl("/")
                    .permitAll()
                .and()
                    .logout()
                .and()
                    .csrf().disable();
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
