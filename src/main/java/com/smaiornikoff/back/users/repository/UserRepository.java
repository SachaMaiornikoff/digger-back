package com.smaiornikoff.back.users.repository;

import com.smaiornikoff.back.users.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Integer> {
}