package com.ofti.basicauthentification;

import com.ofti.basicauthentification.entities.Product;
import com.ofti.basicauthentification.entities.Role;
import com.ofti.basicauthentification.entities.RoleName;
import com.ofti.basicauthentification.entities.UserEntity;
import com.ofti.basicauthentification.repositories.ProductRepository;
import com.ofti.basicauthentification.repositories.UserEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BasicAuthentificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicAuthentificationApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(ProductRepository productRepository, UserEntityRepository userEntityRepository
    , BCryptPasswordEncoder passwordEncoder){
        return args -> {
            userEntityRepository.save(new UserEntity(null,"lotfi",passwordEncoder.encode("12345"), Arrays.asList(new Role(RoleName.ROLE_ADMIN))) );
            userEntityRepository.save(new UserEntity(null,"ali",passwordEncoder.encode("123"), Arrays.asList(new Role(RoleName.ROLE_USER))) );
            productRepository.save(new Product(null,"omo","hi product",200));
            productRepository.save(new Product(null,"juice","hi product",1.200));
            productRepository.save(new Product(null,"milk","hi product",2.100));
        };
    }

}
