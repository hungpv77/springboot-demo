package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

/**
 * @author Hung V. PHAM
 *
 */
public interface ProductService {

    public void init();

    public List<Product> findAll();

    public void addProduct(Product product);

    public void deleteProduct(int id);

    public Product findById(int id);

    public void updateProduct(Product product);

}
