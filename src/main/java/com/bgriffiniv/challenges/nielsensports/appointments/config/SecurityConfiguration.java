package com.bgriffiniv.challenges.nielsensports.appointments.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(GET, "/").permitAll()
				.antMatchers(POST, "/appointments/**").permitAll()
				.antMatchers(GET, "/appointments/**").permitAll()
				.antMatchers(PUT, "/appointments/**").permitAll()
				.antMatchers(DELETE, "/appointments/**").permitAll()
				.anyRequest().denyAll();
	}
}