package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.CustomerDAO;
import com.example.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerRepository;
	
	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		customerRepository.save(theCustomer);
	}

	@Override
	public Customer getCustomer(int Id) {
		return customerRepository.findById(Id).get();
	}

	@Override
	public void deleteCustomer(int theId) {
		customerRepository.deleteById(theId);
	}

}
