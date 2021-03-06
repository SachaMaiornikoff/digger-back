package com.smaiornikoff.back.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameInput {

    String title;

    String studio;

    String releaseDate;

    String coverUrl;

    String gameplayImageUrl;

    String storyline;

    String summary;

    String igdb;

    String g2alink;
}
