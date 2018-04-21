package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Hung V. PHAM
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.formLogin().loginPage("/loginpage").usernameParameter("username").passwordParameter("password")
                .failureUrl("/loginpage?error=true").successForwardUrl("/home").defaultSuccessUrl("/home");
        http.authorizeRequests().antMatchers("/admin**").hasAnyRole("ADMIN").antMatchers("/user**")
                .hasAnyRole("USER", "ADMIN").antMatchers("/css/**", "/js/**", "/loginpage").permitAll().anyRequest()
                .authenticated();
        // http.authorizeRequests().anyRequest().permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }

}
