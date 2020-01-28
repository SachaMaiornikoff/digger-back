package com.smaiornikoff.back.repository;

import com.smaiornikoff.back.model.Users;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface UsersRepository extends ElasticsearchRepository<Users, String> {

    Optional<Users> findByEmail(String email);

    Optional<Users> findByPseudo(String pseudo);
}
