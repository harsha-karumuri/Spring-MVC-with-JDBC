package com.accenture.service;

import com.accenture.dao.CustomerDAO;
import com.accenture.model.Customer;

public class CustomerService {
	
	public int addCustomer(Customer customer) {
		
		CustomerDAO customerDAO= new CustomerDAO();
		return customerDAO.addCustomer(customer);
		
	}

}
