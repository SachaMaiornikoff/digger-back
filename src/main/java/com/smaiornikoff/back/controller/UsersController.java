package com.smaiornikoff.back.controller;

import com.smaiornikoff.back.model.Users;
import com.smaiornikoff.back.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.servlet.http.HttpServletRequest;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Controller
@RequestMapping(value = "/users", produces = APPLICATION_JSON_VALUE)
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    @GetMapping(value = "/{id}")
    public ResponseEntity getUserById(HttpServletRequest httpServletRequest, @PathVariable("id") Integer id) {
        return new ResponseEntity(usersService.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/sign-up")
    public ResponseEntity signUp(HttpServletRequest httpServletRequest, @RequestBody Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return new ResponseEntity(usersService.index(user), HttpStatus.OK);
    }

}
