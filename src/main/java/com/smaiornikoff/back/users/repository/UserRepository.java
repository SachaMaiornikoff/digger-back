package com.smaiornikoff.back.users.repository;

import com.smaiornikoff.back.users.model.Users;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<Users, Integer> {
}