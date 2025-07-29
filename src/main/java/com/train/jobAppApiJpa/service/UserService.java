package com.train.jobAppApiJpa.service;

import com.train.jobAppApiJpa.model.User;
import com.train.jobAppApiJpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User saveUser(User user) {
        return repo.save(user);
    }
}
