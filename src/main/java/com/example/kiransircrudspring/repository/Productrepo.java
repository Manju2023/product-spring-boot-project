package com.example.kiransircrudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kiransircrudspring.entity.Product;

public interface Productrepo extends JpaRepository<Product, Integer> {

}
