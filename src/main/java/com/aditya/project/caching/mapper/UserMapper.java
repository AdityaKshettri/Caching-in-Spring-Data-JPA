package com.aditya.project.caching.mapper;

import com.aditya.project.caching.dto.User;
import com.aditya.project.caching.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User map(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        return user;
    }

    public UserEntity map(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        return userEntity;
    }
}
