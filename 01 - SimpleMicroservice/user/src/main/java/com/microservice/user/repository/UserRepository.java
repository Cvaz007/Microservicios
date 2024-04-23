package com.microservice.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.user.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity,String>{

}
