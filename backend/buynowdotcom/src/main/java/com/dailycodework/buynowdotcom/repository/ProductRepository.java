package com.dailycodework.buynowdotcom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dailycodework.buynowdotcom.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryNameAndBrand(String category, String brand);

    List<Product> findByCategoryName(String category);

    List<Product> findByNameAndBrand(String brand, String name);

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Product> findByName(String name);

    List<Product> findByBrand(String brand);

    boolean existsByNameAndBrand(String name, String brand);

    List<Product> findAllByCategoryId(Long categoryId);

}
