package com.txt.eshopperboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.txt.eshopperboot.dto.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
