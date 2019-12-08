package com.smaiornikoff.back.game.service;

import com.smaiornikoff.back.game.model.GameInput;
import com.smaiornikoff.back.game.model.GameOutput;

import java.util.List;


public interface GameService {

    GameOutput save(GameInput game);

    void delete(String gameId);

    GameOutput findOne(String id);

    List<GameOutput> findAll();

    GameOutput update(GameInput gameInput, String gameId);
}
