package com.smaiornikoff.back.game.service;

import com.smaiornikoff.back.game.model.Game;
import com.smaiornikoff.back.game.model.GameInput;


public interface GameService {

    Game save(GameInput game);

    void delete(String gameId);

    Game findOne(String id);

    Iterable<Game> findAll();

    Game update(GameInput gameInput, String gameId);
}
