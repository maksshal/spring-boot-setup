package com.maksshal.spring.setup.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Security config
 */
@Configuration
@EnableWebSecurity
public class MsWebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
            .antMatchers("/test/*").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic() //enable basic auth
            .and()
            .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception
    {
        //there is one user for whole API
        UserDetails user = User.withUsername("user")
                 .password("{bcrypt}$2a$10$6x9XORz2cviaZnM4kLuYX.N1EFimhguH1Qa.eoB3rqqmqIR//vvQS")
                 .roles("API_CONSUMER")
                 .build();
        
        auth.inMemoryAuthentication().withUser(user);
    }
}
