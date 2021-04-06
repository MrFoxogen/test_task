package com.example.test.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    public static final String AUTHORIZATION = "Authorization";
    private static final String BACKOFFICE = "BACKOFFICE";
    public static final String API_V_1_DEVICES = "/api/v1/devices/list";
    public static final String API_TOKEN = "/api/v1/token";
    public static final String CLIENT = "CLIENT";

    private final JwtUtil jwtUtil;

    @Autowired
    public JWTFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            FilterChain filterChain)
            throws ServletException, IOException {

        if (httpServletRequest.getMethod().equals(HttpMethod.GET.name())
                && httpServletRequest.getServletPath().equals(API_TOKEN)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        String token = httpServletRequest.getHeader(AUTHORIZATION);
        String roleFromToken = jwtUtil.getRoleFromToken(token);
        String userId = jwtUtil.getUserId(token);

        if (userId == null) {
            httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
            httpServletResponse.getWriter().write("User with current id doesn't found");
            return;
        }

        if (roleFromToken == null) {
            httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
            httpServletResponse.getWriter().write("User doesn't have any role");
            return;
        }

        if (!httpServletRequest.getServletPath().equals(API_V_1_DEVICES)
                && roleFromToken.equals(CLIENT)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        if (httpServletRequest.getMethod().equals(HttpMethod.GET.name())
                && httpServletRequest.getServletPath().equals(API_V_1_DEVICES)
                && roleFromToken.equals(BACKOFFICE)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
        httpServletResponse.getWriter().write("User doesn't have permissions");

    }

}
