package com.nimap.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.nimap.model.Category_list;
import com.nimap.repository.Category_Repository;

@Service
public class Category_Services {
    @Autowired
    private Category_Repository categoryRepository;

    public List<Category_list> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category_list getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category_list createCategory(Category_list category) {
        return categoryRepository.save(category);
    }

    public Category_list updateCategory(Category_list category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
    public List<Category_list> getAllCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category_list> categoryPage = categoryRepository.findAll(pageable);
        return categoryPage.getContent();
    }
}


