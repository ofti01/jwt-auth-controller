package com.ofti.basicauthentification.repositories;

import com.ofti.basicauthentification.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByUserName(String name);
}
