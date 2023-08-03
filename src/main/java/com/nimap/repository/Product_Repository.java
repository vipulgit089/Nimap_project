package com.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.model.Product_list;

public interface Product_Repository extends JpaRepository<Product_list, Long> {
}
