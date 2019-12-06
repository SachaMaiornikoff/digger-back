package com.smaiornikoff.back.users.service.impl;

import com.smaiornikoff.back.users.model.Users;
import com.smaiornikoff.back.users.repository.UserRepository;
import com.smaiornikoff.back.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    UserRepository userRepository;

    public Users getUser(Integer id) {
        Optional<Users> user = userRepository.findById(id);

        return user == null ? null : user.get();
    }
}
