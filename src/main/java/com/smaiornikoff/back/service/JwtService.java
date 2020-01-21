package com.smaiornikoff.back.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {

    String createToken(Authentication auth);

    UsernamePasswordAuthenticationToken getAuthentication(String token);
}
