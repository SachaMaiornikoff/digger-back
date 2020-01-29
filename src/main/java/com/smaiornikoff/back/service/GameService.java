package com.smaiornikoff.back.service;

import com.smaiornikoff.back.model.Game;
import com.smaiornikoff.back.model.GameInput;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface GameService {

    Game save(GameInput game);

    void delete(String gameId);

    Game findOne(String id);

    Iterable<Game> findAll();

    Page<Game> findAllPaginate(Integer pageNum);

    Game update(GameInput gameInput, String gameId);
}
