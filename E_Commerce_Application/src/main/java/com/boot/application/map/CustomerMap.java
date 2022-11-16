package com.boot.application.map;

import com.boot.application.dto.CustomerDto;
import com.boot.application.dto.ProductIteamDto;
import com.boot.application.entity.Customer;
import com.boot.application.entity.ProductItems;

public class CustomerMap {
	
	
	private CustomerMap() {
		
	}

	public static Customer insertDataInMainEntity(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setContact(customerDto.getContact());
		customer.setEmail(customerDto.getEmail());
		customer.setLocation(customerDto.getLocation());
		customer.setName(customerDto.getName());
		customer.setPassword(customerDto.getPassword());
		customer.setUserName(customerDto.getUserName());
		customer.setRole("customer");
		return customer;

	}
	
	public static ProductItems convertProductDtoToProduct(ProductIteamDto productDto) {
		ProductItems product=new ProductItems();
		product.setDescription(productDto.getDescription());
		product.setProductName(productDto.getProductName());
		product.setImage(productDto.getImage());
		product.setPrice(productDto.getPrice());
		product.setQuantity(productDto.getQuantity());
		return product;
	}
}
