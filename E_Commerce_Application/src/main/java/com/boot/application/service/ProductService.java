package com.boot.application.service;

import java.util.ArrayList;
import java.util.List;

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
		ProductItems product = CustomerMap.convertProductDtoToProduct(productIteamDto);
		System.out.println(product);
		if (!this.productRepository.existsById(product.getProductId())) {
			System.out.println("Inserting product to database");
			this.productRepository.save(product);
			return true;
		}
		return false;
	}
	
	public boolean updateProduct(ProductIteamDto productIteamDto) {
		if(this.productRepository.existsById(productIteamDto.getProductId()))
		{
			ProductItems product=CustomerMap.convertProductDtoToProduct(productIteamDto);
		System.out.println("Product Converted from valuemapper :" + product);
		this.productRepository.save(product);
		return true;
		}
		System.out.println("Product not found with the given product id :" + productIteamDto.getProductId());
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

	public ProductItems getProductById(int productId) {
		System.out.println("product get by id == "+this.productRepository.findById(productId).get());
		return this.productRepository.findById(productId).get();

	}

	public void deleteProduct(int productId) {
		if(this.productRepository.existsById(productId)) {
			productRepository.deleteById(productId);
		}
		
	}

	
}
