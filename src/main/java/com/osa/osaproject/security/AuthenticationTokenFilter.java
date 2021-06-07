package com.osa.osaproject.security;

import com.osa.osaproject.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil util;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        final String authorizationHeader = httpServletRequest.getHeader("Authorization");

        String username = null;
        String token = null;

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = getJwtTokenFromHeader(authorizationHeader);
            username = util.getUsernameFromToken(token);
            request.setAttribute("username", username);
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if(util.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        chain.doFilter(request, response);
    }

    private String getJwtTokenFromHeader(String authHeader) {
        if (authHeader == null || authHeader.isEmpty() || !authHeader.startsWith("Bearer ")) {
            return null;
        }

        String[] headerTokens = authHeader.split(" ");
        return headerTokens.length == 2 ? headerTokens[1] : null;
    }
}
