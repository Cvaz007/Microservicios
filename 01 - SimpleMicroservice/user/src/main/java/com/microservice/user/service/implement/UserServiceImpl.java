package com.microservice.user.service.implement;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.user.entity.UserEntity;
import com.microservice.user.exception.ResourceNotFoundException;
import com.microservice.user.repository.UserRepository;
import com.microservice.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<UserEntity> getAllUsers() {

    return userRepository.findAll();
  }

  @Override
  public UserEntity getUser(String userId) {

    return userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not fount with the ID: " + userId));
  }

  @Override
  public UserEntity saveUser(UserEntity user) {

    String randomUserId = UUID.randomUUID().toString();
    user.setUserId(randomUserId);

    return userRepository.save(user);
  }

}
