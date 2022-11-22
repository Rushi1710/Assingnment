package com.boot.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.application.entity.ProductItems;

public interface ProductRepository extends JpaRepository<ProductItems, Integer>{

	public List<ProductItems> findByproductName(String productName);
	
	/*
	 * @Transactional
	 * 
	 * @Modifying
	 * 
	 * @Query(nativeQuery = true,value =
	 * "update productItems set quantity=? where productId=?") void
	 * updateQuantityOfProductAfterOrder(@Param("quantity") int
	 * deductedQuantity,@Param("productId") int itemId);
	 */
}
