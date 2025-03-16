package com.nimap.crudapp.services.implementations;

import com.nimap.crudapp.entity.Product;
import com.nimap.crudapp.repository.IProductRepository;
import com.nimap.crudapp.services.ICategoryService;
import com.nimap.crudapp.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product productDetails) {
        return productRepository.findById(id).map(product -> {
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
