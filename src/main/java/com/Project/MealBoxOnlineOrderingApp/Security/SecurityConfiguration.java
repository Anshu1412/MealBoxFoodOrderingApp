package com.Project.MealBoxOnlineOrderingApp.Security;

import com.Project.MealBoxOnlineOrderingApp.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

 @Autowired
 public MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }
////doing csrf is not a good thing in production project ....//////
@Override
protected void configure(HttpSecurity http) throws Exception{
    http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/viewMenu/*","/viewHotels").hasRole("ADMIN")
            .antMatchers("/hotels","/viewProfile").hasRole("USER")
            .antMatchers("/").permitAll()
//            .antMatchers("/login","/register").permitAll()
            .and().formLogin().loginPage("/login").defaultSuccessUrl("/success");
}

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
