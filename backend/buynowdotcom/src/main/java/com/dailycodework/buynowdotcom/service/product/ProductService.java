package com.dailycodework.buynowdotcom.service.product;

import java.util.List;

import com.dailycodework.buynowdotcom.model.Product;
import com.dailycodework.buynowdotcom.request.AddProductRequest;


public interface ProductService {
    Product addProduct(AddProductRequest request);

    Product updateProduct(Product product, Long productId);

    Product getProductById(Long productId);

    void deleteProductById(Long productId);

    List<Product> getAllProducts();

    List<Product> getProductsByCategoryAndBrand(String category, String brand);

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByBrandAndName(String brand, String name);

    List<Product> getProductsByBrand(String brand);

    List<Product> getProductsByName(String name);

}
