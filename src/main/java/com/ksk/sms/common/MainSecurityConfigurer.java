package com.ksk.sms.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
 
@Configuration
@EnableWebSecurity
public class MainSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**", "/img/**", "/js/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.cors().and().csrf().disable();
        http
	        .authorizeRequests()
	            .antMatchers("/", "/login", "/error").permitAll()
	            .anyRequest()
	            .authenticated()
	            .and()
	        .formLogin()
	            .loginPage("/login")
	            .loginProcessingUrl("/authenticate")
	            .defaultSuccessUrl("/mainmenu")
	            .failureUrl("/login")
	            .usernameParameter("username")
	            .passwordParameter("password")
	            .and()
	        .logout()
	            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	            .logoutSuccessUrl("/login")
	            .deleteCookies("JSESSIONID")
	            .invalidateHttpSession(true)
	            .permitAll()
	            .and()
	        .sessionManagement()
	            .invalidSessionUrl("/invalidSession");
    }
}
