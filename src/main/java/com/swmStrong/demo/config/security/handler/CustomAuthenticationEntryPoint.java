package com.swmStrong.demo.config.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    public CustomAuthenticationEntryPoint(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException
    ) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Map<String, Object> responseMap = new HashMap<>();

        AuthenticationException filterException = (AuthenticationException) request.getAttribute("exception");
        String message = filterException != null ? filterException.getMessage() : authException.getMessage();

        responseMap.put("isSuccess", false);
        responseMap.put("code", "4011");
        responseMap.put("message", message);
        responseMap.put("data", null);

        objectMapper.writeValue(response.getOutputStream(), responseMap);
    }
}