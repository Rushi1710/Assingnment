package com.boot.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.application.dto.ProductIteamDto;
import com.boot.application.entity.ProductItems;
import com.boot.application.map.CustomerMap;
import com.boot.application.repository.ProductRepository;



@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	public boolean insertProduct(ProductIteamDto productIteamDto) {
		ProductItems product=CustomerMap.convertProductDtoToProduct(productIteamDto);
		System.out.println(product);
		if(!this.productRepository.existsById(product.getProductId()))
		{
			System.out.println("Inserting product to database");
			this.productRepository.save(product);
			return true;
		}
		return false;
	}

	public List<ProductItems> getAllProduct() {

		List<ProductItems> product = new ArrayList<>();
		this.productRepository.findAll().forEach(product::add);
		return product;

	}

	public List<ProductItems> getProductBySearch(String productName) {
		return this.productRepository.findByproductName(productName);

	}

	public Optional<ProductItems> getProductBuyNow(int id) {
		return this.productRepository.findById(id);
	}

	public Optional<ProductItems> getProductById(int productId) {
		return this.productRepository.findById(productId);

	}
}
