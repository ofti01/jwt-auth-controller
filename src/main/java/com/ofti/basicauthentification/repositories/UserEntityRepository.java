package com.ofti.basicauthentification.repositories;

import com.ofti.basicauthentification.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

   Optional<UserEntity> findByUserName(String name);
}
