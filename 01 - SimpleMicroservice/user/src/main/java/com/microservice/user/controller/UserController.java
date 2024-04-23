package com.microservice.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.user.entity.UserEntity;
import com.microservice.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity userRequest) {
    UserEntity user = userService.saveUser(userRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }

  @GetMapping("/{userId}")
  public ResponseEntity<UserEntity> findUser(@PathVariable String userId) {
    UserEntity user = userService.getUser(userId);
    return ResponseEntity.ok(user);
  }

  @GetMapping
  public ResponseEntity<List<UserEntity>> findAllUser() {
    List<UserEntity> user = userService.getAllUsers();
    return ResponseEntity.ok(user);
  }
}
