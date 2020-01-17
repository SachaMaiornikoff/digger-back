package com.smaiornikoff.users.controller;

import com.smaiornikoff.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Controller
@RequestMapping(value = "/games", produces = APPLICATION_JSON_VALUE)
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getGameById(HttpServletRequest httpServletRequest, @PathVariable("id") Integer gameId) {
        return new ResponseEntity<>(usersService.findOne(gameId), HttpStatus.OK);
    }

}
