package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
	public Customer getCustomer(int Id);

	public void deleteCustomer(int theId);
	
}
