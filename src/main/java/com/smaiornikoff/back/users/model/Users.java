package com.smaiornikoff.back.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "user", type = "_doc")
public class Users {

    @Id
    private Integer id;

    private String password;

    private String email;

    private Integer privileges;

    private String description;

}
