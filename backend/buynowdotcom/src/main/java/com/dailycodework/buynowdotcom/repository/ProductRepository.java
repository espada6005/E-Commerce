package com.dailycodework.buynowdotcom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailycodework.buynowdotcom.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryNameAndBrand(String category, String brand);

    List<Product> findByCategoryName(String category);

    List<Product> findByNameAndBrand(String brand, String name);

    List<Product> findByName(String name);

    List<Product> findByBrand(String brand);

}
