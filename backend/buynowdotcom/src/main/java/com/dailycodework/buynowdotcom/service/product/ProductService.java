package com.dailycodework.buynowdotcom.service.product;

import java.util.List;

import com.dailycodework.buynowdotcom.dtos.ProductDto;
import com.dailycodework.buynowdotcom.model.Product;
import com.dailycodework.buynowdotcom.request.AddProductRequest;
import com.dailycodework.buynowdotcom.request.ProductUpdateRequest;


public interface ProductService {
    Product addProduct(AddProductRequest request);

    Product updateProduct(ProductUpdateRequest request, Long productId);

    Product getProductById(Long productId);

    void deleteProductById(Long productId);

    List<Product> getAllProducts();

    List<Product> getProductsByCategoryAndBrand(String category, String brand);

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByBrandAndName(String brand, String name);

    List<Product> getProductsByBrand(String brand);

    List<Product> getProductsByName(String name);

    List<Product> findDistinctProductsByName();

    List<String> getAllDistinctBrands();

    List<Product> getProductsByCategoryId(Long categoryId);

    List<ProductDto> getConvertedProducts(List<Product> products);

    ProductDto convertToDto(Product product);
    
}

