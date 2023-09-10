package io.mkolodziejczyk92.eventplannerapp.data.security.token;

import io.mkolodziejczyk92.eventplannerapp.data.constant.SecurityConstant;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    private final JwtProvider tokenProvider;

    public AuthorizationFilter(JwtProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain)
            throws ServletException, IOException {
        if(request.getMethod().equals(SecurityConstant.HTTP_METHODS)){
            response.setStatus(HttpStatus.OK.value());
        } else {
            String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            if(authHeader == null || !authHeader.startsWith(SecurityConstant.TOKEN_FRONT)){
                filterChain.doFilter(request, response);
                return;
            }
            setContext(request, authHeader);
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token expired");
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private void setContext(HttpServletRequest request, String authHeader) {
        String token = authHeader.substring(SecurityConstant.TOKEN_FRONT.length());
        String username = tokenProvider.getSubject(token);
        if(tokenProvider.isTokenValid(username, token) && SecurityContextHolder.getContext().getAuthentication() == null){
            List<GrantedAuthority> grantedAuthorities = tokenProvider.getAuthorities(token);
            Authentication authentication = tokenProvider.getAuthentication(username, grantedAuthorities, request);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            SecurityContextHolder.clearContext();
        }
    }
}
