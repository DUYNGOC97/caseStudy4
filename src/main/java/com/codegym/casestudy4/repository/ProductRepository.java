package com.codegym.casestudy4.repository;

import com.codegym.casestudy4.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();
    Product findProductById(long id);
}
