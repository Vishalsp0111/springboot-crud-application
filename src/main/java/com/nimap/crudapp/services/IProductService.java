package com.nimap.crudapp.services;

import com.nimap.crudapp.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> getAllProducts(Pageable pageable);
    Optional<Product> getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product productDetails);
    void deleteProduct(Long id);
}
