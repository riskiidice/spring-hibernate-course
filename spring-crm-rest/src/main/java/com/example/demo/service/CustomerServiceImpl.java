package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		customerRepository.save(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		return customerRepository.findById(theId).orElse(null);
	}

	@Override
	public void deleteCustomer(int theId) {
		customerRepository.deleteById(theId);
	}

}
