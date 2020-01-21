package com.smaiornikoff.back.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smaiornikoff.back.model.Users;
import com.smaiornikoff.back.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;

        this.jwtService = jwtService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            Users creds = new ObjectMapper()
                .readValue(req.getInputStream(), Users.class);

            return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    creds.getEmail(),
                    creds.getPassword(),
                    new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String token = jwtService.createToken(auth);
        res.addHeader("Content-Type", "application/json");
        res.getWriter().write("{\"token\":\"" + token + "\"}");
    }
}