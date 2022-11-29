package com.boot.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.application.repository.AddCartRepository;

@Service
public class AddToCartService {

	@Autowired
	private AddCartRepository addCartRepository;

	public void deleteProduct(int productId) {
		if (this.addCartRepository.existsById(productId)) {
			this.addCartRepository.deleteById(productId);
		}
	}

}
