package com.microservice.user.controller;

import java.util.List;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
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

    int quantityRetries = 1;

    @GetMapping("/{userId}")
    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<UserEntity> findUser(@PathVariable String userId) {
        log.info("List an user : UserController");
        log.info("Quantity of retries : {}", quantityRetries);
        quantityRetries++;
        UserEntity user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAllUser() {
        List<UserEntity> user = userService.getAllUsers();
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<UserEntity> ratingHotelFallback(String userID, Exception exception) {
        log.info("The backup is executed because the service is inactive: ", exception.getMessage());
        UserEntity user = UserEntity.builder()
                .email("ecample@gmail.com")
                .name("example")
                .information("example")
                .userId("id_example")
                .build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
