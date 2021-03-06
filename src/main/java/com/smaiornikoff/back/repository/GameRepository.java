package com.smaiornikoff.back.repository;

import com.smaiornikoff.back.model.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface GameRepository extends ElasticsearchRepository<Game, String> {

    Page<Game> getGamesByTitleContaining(String title, Pageable pageable);

    Optional<Game> getGamesByIgdbEquals(String igdb);
}
