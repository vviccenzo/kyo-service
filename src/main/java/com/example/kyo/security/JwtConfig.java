package com.example.kyo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
public class JwtConfig {

	@Bean
	public OncePerRequestFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}
}
