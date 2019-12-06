package com.smaiornikoff.back.game.service.impl;

import com.smaiornikoff.back.game.model.Game;
import com.smaiornikoff.back.game.model.GameInput;
import com.smaiornikoff.back.game.repository.GameRepository;
import com.smaiornikoff.back.game.service.GameService;
import org.apache.commons.codec.digest.DigestUtils;
import org.elasticsearch.action.update.UpdateResponse;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game save(GameInput game) {

        String idHash = DigestUtils.sha1Hex(DateTime.now().toString()).substring(15);

        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy");

        Game newGame = Game.builder()
            .id(idHash)
            .releaseDate(fmt.parseDateTime(game.getReleaseDate()).toString(fmt))
            .studio(game.getStudio())
            .title(game.getTitle())
            .build();

        return gameRepository.index(newGame);
    }

    public void delete(String gameId) {
        gameRepository.deleteById(gameId);
    }

    public Optional<Game> findOne(String id) {
        return gameRepository.findById(id);
    }

    public Iterable<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game update(GameInput gameInput, String gameId) {
        Game game = Game.builder()
            .id(gameId)
            .releaseDate(gameInput.getReleaseDate())
            .studio(gameInput.getStudio())
            .title(gameInput.getTitle())
            .build();



        return gameRepository.save(game);
    }

}
