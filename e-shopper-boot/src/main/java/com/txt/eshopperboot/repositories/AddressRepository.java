package com.txt.eshopperboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.txt.eshopperboot.dto.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
