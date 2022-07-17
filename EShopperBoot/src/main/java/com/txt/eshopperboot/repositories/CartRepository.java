package com.txt.eshopperboot.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.txt.eshopperboot.dto.Cart;

@Transactional
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	List<Cart> findByUserId(int userId);

	Cart findByUserIdAndProductId(int userId, int productId);

	@Modifying
	@Query(value = "update cart set buying_price = ? where user_id = ? and product_id = ?", nativeQuery = true)
	int updateCart(double buyingPrice, int userId, int productId);

}
