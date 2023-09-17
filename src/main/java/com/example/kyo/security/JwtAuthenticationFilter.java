package com.example.kyo.security;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String token = request.getHeader("Authorization");

		if (token != null && token.startsWith("Bearer ")) {
			token = token.substring(7); // Remova "Bearer "

			try {
				Jwts.parser().setSigningKey("your-secret-key").parseClaimsJws(token);
				filterChain.doFilter(request, response);
			} catch (SignatureException e) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}
}
