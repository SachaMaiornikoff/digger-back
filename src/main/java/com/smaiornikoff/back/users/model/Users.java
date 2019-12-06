package com.smaiornikoff.back.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "user")
public class Users {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String password;

    private String email;

    private Integer privileges;

    private String description;

}
