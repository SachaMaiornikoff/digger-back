package com.smaiornikoff.back.game.controller;

import com.smaiornikoff.back.game.model.GameInput;
import com.smaiornikoff.back.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Controller
@RequestMapping(value = "/games", produces = APPLICATION_JSON_VALUE)
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "")
    public ResponseEntity getFolders(HttpServletRequest httpServletRequest) throws IOException {
        return new ResponseEntity<>(gameService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity createFolders(HttpServletRequest httpServletRequest, @RequestBody GameInput game) {
        return new ResponseEntity(gameService.save(game), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteFolders(HttpServletRequest httpServletRequest, @PathVariable("id") String gameId) {

        gameService.delete(gameId);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity updateFolders(HttpServletRequest httpServletRequest, @RequestBody GameInput game, @PathVariable("id") String gameId) {
        return new ResponseEntity(gameService.update(game, gameId), HttpStatus.OK);
    }

}
