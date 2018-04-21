package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Category;

/**
 * @author Hung V. PHAM
 *
 */
public interface CategoryService {

    public void init();

    public List<Category> findAll();

}
