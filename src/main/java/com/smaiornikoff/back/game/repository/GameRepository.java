package com.smaiornikoff.back.game.repository;

import com.smaiornikoff.back.game.model.Game;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface GameRepository extends ElasticsearchRepository<Game, String> {

}
