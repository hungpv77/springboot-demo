package com.example.demo.service;

import java.util.List;

/**
 * @author Hung V. PHAM
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void init() {
        logger.info("INFO: Init Product");

        Category category = new Category();
        category.setName("Category 1");
        categoryRepository.save(category);

        Category category2 = new Category();
        category2.setName("Category 2");
        categoryRepository.save(category2);

        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setCategory(category);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setCategory(category);
        productRepository.save(product2);

    }

    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.delete(id);
    }

    @Override
    public Product findById(int id) {
        // TODO Auto-generated method stub
        return productRepository.findOne(id);
    }

    @Override
    public void updateProduct(Product product) {
        // TODO Auto-generated method stub
        logger.info("ProductName=" + product.getName());
        logger.info("ProductId=" + product.getProdId());
        productRepository.save(product);
    }

}
