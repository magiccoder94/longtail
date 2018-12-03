package com.my.longtail.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@Order(2)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Override
	public void configure(final WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/assets/**");
		web.ignoring().antMatchers("/render/**");
		web.ignoring().antMatchers("/sample/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/investor/**").permitAll()
			.and()
				.oauth2Login()
				.defaultSuccessUrl("/investor/loginSuccess")
			.and().csrf().disable();
	}
	
}
