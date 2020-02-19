package com.smaiornikoff.back.service.impl;

import com.smaiornikoff.back.model.Game;
import com.smaiornikoff.back.model.GameInput;
import com.smaiornikoff.back.repository.GameRepository;
import com.smaiornikoff.back.service.GameService;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game save(GameInput game) {

        String idHash = DigestUtils.sha1Hex(DateTime.now().toString()).substring(15);

        DateTimeFormatter fmtInput = DateTimeFormat.forPattern("yyyy-MM-dd");

        DateTimeFormatter fmtOutput = DateTimeFormat.forPattern("dd/MM/yyyy");

        Game newGame = Game.builder()
            .id(idHash)
            .releaseDate(fmtInput.parseDateTime(game.getReleaseDate()).toString(fmtOutput))
            .studio(game.getStudio())
            .title(game.getTitle())
            .coverUrl(game.getCoverUrl())
            .gameplayImageUrl(game.getGameplayImageUrl())
            .storyline(game.getStoryline())
            .summary(game.getSummary())
            .igdb(game.getIgdb())
            .g2alink(game.getG2alink())
            .build();

        gameRepository.index(newGame);

        return newGame;
    }

    public void delete(String gameId) {
        gameRepository.deleteById(gameId);
    }

    public Game findOne(String id) {
        Optional<Game> game = gameRepository.findById(id);

        return game.isPresent() ? game.get() : null;
    }

    public Iterable<Game> findAll() {
        Iterable<Game> games = gameRepository.findAll();

        return games;
    }

    public Page<Game> findAllPaginate(Integer pageNum) {
        Page<Game> games = gameRepository.findAll(PageRequest.of(pageNum, 60, Sort.Direction.ASC, "title.keyword"));

        return games;
    }

    public Game update(GameInput gameInput, String gameId) {
        DateTimeFormatter fmtInput = DateTimeFormat.forPattern("yyyy-MM-dd");

        DateTimeFormatter fmtOutput = DateTimeFormat.forPattern("dd/MM/yyyy");
        Game game = Game.builder()
            .id(gameId)
            .releaseDate(fmtInput.parseDateTime(gameInput.getReleaseDate()).toString(fmtOutput))
            .studio(gameInput.getStudio())
            .title(gameInput.getTitle())
            .coverUrl(gameInput.getCoverUrl())
            .gameplayImageUrl(gameInput.getGameplayImageUrl())
            .storyline(gameInput.getStoryline())
            .summary(gameInput.getSummary())
            .igdb(gameInput.getIgdb())
            .g2alink(gameInput.getG2alink())
            .build();

        return gameRepository.save(game);
    }
}
