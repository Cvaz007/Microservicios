package com.microservice.user.service;

import java.util.List;

import com.microservice.user.entity.UserEntity;

public interface UserService {

  UserEntity saveUser(UserEntity user);

  List<UserEntity> getAllUsers();

  UserEntity getUser(String userId);
}
