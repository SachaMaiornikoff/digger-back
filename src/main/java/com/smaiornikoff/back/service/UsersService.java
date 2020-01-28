package com.smaiornikoff.back.service;

import com.smaiornikoff.back.model.Users;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {

    Users findById(Integer id);

    Users findByEmail(String email);

    Users findByPseudo(String pseudo);

    Users index(Users user);

}
