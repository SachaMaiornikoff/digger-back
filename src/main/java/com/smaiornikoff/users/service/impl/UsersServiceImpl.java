package com.smaiornikoff.users.service.impl;

import com.smaiornikoff.users.model.Users;
import com.smaiornikoff.users.repository.UsersRepository;
import com.smaiornikoff.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Value("${Path.folders.images}")
    private String imageFolderPath;

    @Autowired
    private UsersRepository usersRepository;

    public Users findOne(Integer id) {
        Optional<Users> user = usersRepository.findById(id.toString());

        return user.isPresent() ? user.get() : null;
    }

}
