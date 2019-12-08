package com.smaiornikoff.back.users;

import com.smaiornikoff.back.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/users", produces = APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getUser(HttpServletRequest httpServletRequest, @PathVariable("id") Integer userId) {
        return new ResponseEntity(userService.getUser(userId), HttpStatus.OK);
    }
}
