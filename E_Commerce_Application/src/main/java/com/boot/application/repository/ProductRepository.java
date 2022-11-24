package com.boot.application.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.application.entity.ProductItems;

public interface ProductRepository extends JpaRepository<ProductItems, Integer> {

	public List<ProductItems> findByproductName(String productName);

	public List<ProductItems> findByproductNameContaining(String productName);

	@Query(nativeQuery = true, value = "select quantity from productitems where productId=?")
	int countProductQuantity(@Param("productId") int id);

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update productitems set quantity=? where productId=?")
	void updateQuantityOfProductAfterOrder(@Param("quantity") int deductedQuantity, @Param("productId") int itemId);
}
