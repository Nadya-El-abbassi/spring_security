package org.example.tp_security.repository;

import org.example.tp_security.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {
}
