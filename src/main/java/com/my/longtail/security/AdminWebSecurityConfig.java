package com.my.longtail.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.my.longtail.model.Users;
import com.my.longtail.property.Property;
import com.my.longtail.repositories.UsersRepository;

@Configuration
@Order(1)
public class AdminWebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	final static String foldername = Property.getWEBPORTAL_FOLDER_NAME();
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	UsersRepository userRepository;
	
	@Autowired
	public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.usersByUsernameQuery("SELECT u.username, u.password, u.enabled FROM users u WHERE u.username = ?")
			.authoritiesByUsernameQuery("SELECT u.username, r.role FROM users u "
					+ "INNER JOIN roles r ON r.id = u.role_id "
					+ "WHERE u.username = ?")
			.dataSource(dataSource).passwordEncoder(passwordencoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/admin/**")
			.authenticated()
			.and()
		.formLogin()
			.loginPage("/admin/signin").permitAll()
			.successHandler(new AuthenticationSuccessHandler() {

				@Override
				public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
						Authentication authentication) throws IOException, ServletException {
//					User user = (User) authentication.getPrincipal();
//					Users dbuser = userRepository.findByUsername(user.getUsername());
					System.out.println("test");
					response.sendRedirect(request.getContextPath()+"/admin/welcome");
				}
			}).failureHandler(new AuthenticationFailureHandler() {

				@Override
				public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
						AuthenticationException exception) throws IOException, ServletException {
					response.sendRedirect(request.getContextPath()+"/admin/signin/error");
				}
				
			})
			.usernameParameter("username").passwordParameter("password").and()
			.logout().logoutSuccessUrl("/admin/logout")
			.and().exceptionHandling().accessDeniedPage("/admin/403");
	}
	
	@Bean
	public BCryptPasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
}
