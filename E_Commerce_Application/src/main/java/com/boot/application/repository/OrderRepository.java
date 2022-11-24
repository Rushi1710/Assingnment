package com.boot.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.application.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	List<Order> findAllByCustomerUserName(String userName);

	@Query(nativeQuery = true, value = "select count(*) from order_table where productId=?")
	int countProduct(@Param("productId") int id);

}
