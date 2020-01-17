package com.smaiornikoff.users.repository;

import com.smaiornikoff.users.model.Users;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UsersRepository extends ElasticsearchRepository<Users, String> {

}
