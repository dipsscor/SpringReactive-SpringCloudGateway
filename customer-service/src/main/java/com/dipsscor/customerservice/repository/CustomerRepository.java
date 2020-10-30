package com.dipsscor.customerservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.dipsscor.customerservice.model.Customer;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {
	
}
