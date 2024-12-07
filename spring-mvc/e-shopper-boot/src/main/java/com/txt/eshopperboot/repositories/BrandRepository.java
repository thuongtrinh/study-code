package com.txt.eshopperboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.txt.eshopperboot.dto.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
