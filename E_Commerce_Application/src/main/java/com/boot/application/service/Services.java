package com.boot.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.application.dto.CustomerDto;
import com.boot.application.dto.ProductIteamDto;
import com.boot.application.entity.AddCart;
import com.boot.application.entity.Customer;
import com.boot.application.entity.ProductItems;
import com.boot.application.map.CustomerMap;
import com.boot.application.repository.AddCartRepository;
import com.boot.application.repository.CustomerRepository;

// customer services class for performing customer related operation.
@Service
public class Services {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AddCartRepository addCartRepository;

	private static Logger logger = Logger.getLogger(Services.class);

	// Insert Data CustomerDto To Customer Entity
	public boolean insertCustomerData(CustomerDto customerDto) throws EntityExistsException {
		logger.info("insert CutomerDto to Customer" + customerDto);
		Customer customer = CustomerMap.insertDataInMainEntity(customerDto);
		if (this.customerRepository.existsById(customer.getUserName())) {
			logger.error(customer.getUserName() + "customer username exist");
			throw new EntityExistsException("User Name Already exist");
		} else if (this.customerRepository.existsByEmail(customer.getEmail())) {
			logger.error(customer.getEmail() + "customer email exist");
			throw new EntityExistsException("Email  Already exist");
		} else if (this.customerRepository.existsByContact(customer.getContact())) {
			logger.error(customer.getEmail() + "customer phone number exist");
			throw new EntityExistsException("Phone Number Already exist");
		} else {
			this.customerRepository.save(customer);
			return true;
		}

	}

	// save particular product details with customer id to addcart table .
	public AddCart inserItemToCart(AddCart addcart) {
		this.addCartRepository.save(addcart);
		return addcart;
	}

	// when customer enter user name and password this time check customer data is
	// validated or not.
	public boolean validateCustomer(String userName, String password) {

		if (this.customerRepository.existsById(userName)) {
			String password2 = this.customerRepository.findById(userName).get().getPassword();
			return (password.equals(password2));
		}
		return false;
	}

	public Customer servicesForAdmin(String userName) {
		Customer customer = null;
		Optional<Customer> optional = this.customerRepository.findById(userName);
		if (optional.isPresent()) {
			customer = optional.get();
		}
		return customer;

	}

	// get all data form addcart table .
	public List<AddCart> getAllCartItem() {
		List<AddCart> product = new ArrayList<>();
		this.addCartRepository.findAll().forEach(product::add);
		return product;
	}

	// Fetch single customer By customer user name if customer not present in table
	// then gives customer Not found exception.
	public Customer getCustomerById(String userName) {
		Optional<Customer> optCustomer = this.customerRepository.findById(userName);
		if (optCustomer.isPresent())
			return optCustomer.get();
		throw new EntityNotFoundException("Customer Not Found " + userName);
	}

// update custmoer data and insert into customer entity
	public boolean insertDtoToCustomer(CustomerDto dto) {

		try {
		Customer customer = CustomerMap.insertDataInMainEntity(dto);
//		if (this.customerRepository.existsByEmail(dto.getEmail())
//				|| this.customerRepository.existsByContact(dto.getContact())) {
//			Customer customer1 = getCustomerById(dto.getUserName());
//			if (customer.getEmail().equals(customer1.getEmail())
//					&& customer.getContact().equals(customer1.getContact())) {
//				this.customerRepository.save(customer);
//			}
//			return false;
//		}
		this.customerRepository.save(customer);
		return true;
		}
		catch (Exception e) {
			logger.error(e+"Data not updated .");
			return false;
			
		}
	

	}

}
