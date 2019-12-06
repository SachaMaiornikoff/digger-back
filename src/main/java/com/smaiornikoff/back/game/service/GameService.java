package com.smaiornikoff.back.game.service;

import com.smaiornikoff.back.game.model.Game;
import com.smaiornikoff.back.game.model.GameInput;

import java.util.Optional;


public interface GameService {

    Game save(GameInput game);

    void delete(String gameId);

    Optional<Game> findOne(String id);

    Iterable<Game> findAll();

    Game update(GameInput gameInput, String gameId);
}
