package com.aditya.project.caching.service;

import com.aditya.project.caching.dto.User;
import com.aditya.project.caching.entity.UserEntity;
import com.aditya.project.caching.mapper.UserMapper;
import com.aditya.project.caching.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    public User findById(int id) {
        Optional<UserEntity> userEntity = repository.findById(id);
        if (userEntity.isPresent()) {
            log.info("User found with id : " + id);
            // to see the demo in console
            userEntity = repository.findById(id);
            return mapper.map(userEntity.get());
        } else {
            throw new NullPointerException("User not found with id : " + id);
        }
    }

    public void deleteById(int id) {
        repository.deleteById(id);
        log.info("User deleted with id : " + id);
    }

    public User save(User user) {
        return mapper.map(repository.save(mapper.map(user)));
    }
}
