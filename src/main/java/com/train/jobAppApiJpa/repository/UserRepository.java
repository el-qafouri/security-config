package com.train.jobAppApiJpa.repository;

import com.train.jobAppApiJpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
