package com.auth.jwt.repository;


import com.auth.jwt.entity.AuthUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUserEntity, Integer> {

    Optional<AuthUserEntity> findByUserName(String userName);
}
