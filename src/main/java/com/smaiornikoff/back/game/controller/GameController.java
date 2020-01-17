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
    public ResponseEntity getGames(HttpServletRequest httpServletRequest) throws IOException {
        return new ResponseEntity<>(gameService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getGameById(HttpServletRequest httpServletRequest, @PathVariable("id") String gameId) {
        return new ResponseEntity<>(gameService.findOne(gameId), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity createGame(HttpServletRequest httpServletRequest, @RequestBody GameInput game) {
        return new ResponseEntity(gameService.save(game), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteGame(HttpServletRequest httpServletRequest, @PathVariable("id") String gameId) {

        gameService.delete(gameId);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity updateGame(HttpServletRequest httpServletRequest, @RequestBody GameInput game, @PathVariable("id") String gameId) {
        return new ResponseEntity(gameService.update(game, gameId), HttpStatus.OK);
    }

}
