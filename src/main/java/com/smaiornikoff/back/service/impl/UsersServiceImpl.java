package com.smaiornikoff.back.service.impl;

import com.smaiornikoff.back.model.Users;
import com.smaiornikoff.back.repository.UsersRepository;
import com.smaiornikoff.back.service.UsersService;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Users findById(Integer id) {
        Optional<Users> user = usersRepository.findById(id.toString());

        return user.isPresent() ? user.get() : null;
    }

    public Users findByEmail(String email) {
        Optional<Users> user = usersRepository.findByEmail(email);

        return user.isPresent() ? user.get() : null;
    }

    public Users index(Users user) {
        String idHash = DigestUtils.sha1Hex(DateTime.now().toString()).substring(15);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setId(idHash);

        return usersRepository.index(user);
    }

}
