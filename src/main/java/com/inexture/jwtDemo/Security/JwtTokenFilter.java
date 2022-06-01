//package com.inexture.jwtDemo.Security;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.inexture.jwtDemo.Service.UserDetailsServiceImpl;
//
//public class JwtTokenFilter extends OncePerRequestFilter {
//
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
//
//	@Autowired
//	private UserDetailsServiceImpl userDetailsService;
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		try {
//			String token = getTokenFromRequest(request);
//			System.out.println("Token-- " + token);
//			if (token != null && jwtTokenUtil.validateJwtToken(token)) {
//				System.out.println("inside token not null");
//				String username = jwtTokenUtil.getUserNameFromJwtToken(token);
//				System.out.println("User Name--JwtTokenFilter-- " + username);
//				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//				System.out.println("Authorities--JwtTokenFilter-- " + userDetails.getAuthorities());
//				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//						userDetails, null, userDetails.getAuthorities());
//				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				SecurityContextHolder.getContext().setAuthentication(authentication);
//			}
//		} catch (Exception e) {
//			System.out.println("insdie excetption");
//			logger.error("Cannot set user authentication: {}", e);
//			throw new RuntimeException("Cannot set user authentication" + e.getMessage());
//		}
//		System.out.println("chaining filter");
//		filterChain.doFilter(request, response);
//	}
//
//	private String getTokenFromRequest(HttpServletRequest request) {
//
//		String token = request.getHeader("Authorization");
//
//		System.out.println("My token is :" + token);
//		String newToken = null;
//		if (token != null && token.startsWith("Bearer ")) {
//			newToken = token.substring(7);
//			System.out.println("Token get is :" + token);
//		}
//		return newToken;
//	}
//
//}
