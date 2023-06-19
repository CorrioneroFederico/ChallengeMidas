package com.api.commerce;

import com.api.commerce.models.service.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private JpaUserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
            http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/usuario/listar").hasRole("ADMIN")
                    .antMatchers("/usuario/register").permitAll()
                    .antMatchers("/usuario/login").permitAll()
                    .antMatchers("/producto/**").hasRole("ADMIN")
                    .antMatchers("/producto/listar").hasRole("CLIENTE")
                    .antMatchers("/carrito/listar").hasRole("ADMIN")
                    .antMatchers("/h2-console/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().permitAll()
                    .and()
                    .logout()
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .permitAll()
                    .and()
                    .headers()
                    .frameOptions().sameOrigin()
                    .and()
                    .httpBasic();
    }


    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(userDetailsService).passwordEncoder(this.passwordEncoder);
    }

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}