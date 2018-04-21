package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

/**
 * @author Hung V. PHAM
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void init() {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Category> findAll() {
        // TODO Auto-generated method stub
        return (List<Category>) categoryRepository.findAll();
    }

}
