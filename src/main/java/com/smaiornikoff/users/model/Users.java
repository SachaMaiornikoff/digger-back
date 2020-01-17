package com.smaiornikoff.users.model;

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
@Document(indexName = "user", type = "_doc")
public class Users {

    @Id
    String id;

    String title;

    String studio;

    String releaseDate;
}
