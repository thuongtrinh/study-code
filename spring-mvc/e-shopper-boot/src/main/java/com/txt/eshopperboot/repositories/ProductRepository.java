package com.txt.eshopperboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.txt.eshopperboot.dto.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
