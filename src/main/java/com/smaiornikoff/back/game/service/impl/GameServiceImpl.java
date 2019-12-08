package com.smaiornikoff.back.game.service.impl;

import com.smaiornikoff.back.game.model.Game;
import com.smaiornikoff.back.game.model.GameInput;
import com.smaiornikoff.back.game.model.GameOutput;
import com.smaiornikoff.back.game.repository.GameRepository;
import com.smaiornikoff.back.game.service.GameService;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Value("${Path.folders.images}")
    private String imageFolderPath;

    @Autowired
    private GameRepository gameRepository;

    public GameOutput save(GameInput game) {

        String idHash = DigestUtils.sha1Hex(DateTime.now().toString()).substring(15);

        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy");

        Game newGame = Game.builder()
            .id(idHash)
            .releaseDate(fmt.parseDateTime(game.getReleaseDate()).toString(fmt))
            .studio(game.getStudio())
            .title(game.getTitle())
            .build();

        return mapGameToGameOutput(gameRepository.index(newGame));
    }

    public void delete(String gameId) {
        gameRepository.deleteById(gameId);
    }

    public GameOutput findOne(String id) {
        Optional<Game> game = gameRepository.findById(id);

        return game.isPresent() ? mapGameToGameOutput(game.get()) : null;
    }

    public List<GameOutput> findAll() {
        Iterable<Game> games = gameRepository.findAll();

        List<GameOutput> gameOutputs = new ArrayList<GameOutput>();

        for (Game game : games) {
            gameOutputs.add(mapGameToGameOutput(game));
        }

        return gameOutputs;
    }

    public GameOutput update(GameInput gameInput, String gameId) {
        Game game = Game.builder()
            .id(gameId)
            .releaseDate(gameInput.getReleaseDate())
            .studio(gameInput.getStudio())
            .title(gameInput.getTitle())
            .build();

        return mapGameToGameOutput(gameRepository.save(game));
    }

    private byte[] getImageForGame(Game game) {

        Path path = Paths.get(imageFolderPath + "/" + game.getId() + ".jpg");

        try {
            byte[] media = Files.readAllBytes(path);

            return media;
        } catch (IOException e) {
            Path pathPlaceholder = Paths.get(imageFolderPath + "/Placeholder.png");

            try {
                return Files.readAllBytes(pathPlaceholder);
            }catch (IOException exception) {
                return null;
            }
        }
    }

    private GameOutput mapGameToGameOutput(Game game) {
        return GameOutput.builder().game(game).image(getImageForGame(game)).build();
    }
}
