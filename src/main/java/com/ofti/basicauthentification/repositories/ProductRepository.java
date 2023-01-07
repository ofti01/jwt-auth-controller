package com.ofti.basicauthentification.repositories;

import com.ofti.basicauthentification.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
