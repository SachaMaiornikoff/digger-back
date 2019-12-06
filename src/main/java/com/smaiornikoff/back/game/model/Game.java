package com.smaiornikoff.back.game.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "game", type = "_doc")
public class Game {

    @Id
    String id;

    String title;

    String studio;

    String releaseDate;
}
