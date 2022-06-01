package com.inexture.jwtDemo.Security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{
	
	private static final Logger logger = LogManager.getLogger(JwtAuthenticationEntryPoint.class);  
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		logger.error("Unauthorized access error : " + authException.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized Access");
		
	}

}
