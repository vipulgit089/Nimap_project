package com.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.model.Category_list;

public interface Category_Repository extends JpaRepository<Category_list, Long> {
}
