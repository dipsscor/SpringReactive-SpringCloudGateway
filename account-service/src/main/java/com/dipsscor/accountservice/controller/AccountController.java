package com.dipsscor.accountservice.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dipsscor.accountservice.model.Account;
import com.dipsscor.accountservice.repository.AccountRepository;

import io.swagger.annotations.Api;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AccountController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountRepository repository;

	@GetMapping("/account/customer-Id/{customer}")
	public Flux<Account> findByCustomer(@PathVariable("customer") String customerId) {
		LOGGER.info("findByCustomer: customerId={}", customerId);
		return repository.findByCustomerId(customerId);
	}

	@GetMapping("/account")
	public Flux<Account> findAll() {
		LOGGER.info("findAll");
		return repository.findAll();
	}

	@GetMapping("/account/{id}")
	public Mono<Account> findById(@PathVariable("id") String id) {
		LOGGER.info("findById: id={}", id);
		return repository.findById(id);
	}

	@PostMapping("/account")
	public Mono<Account> create(@RequestBody Account account) {
		LOGGER.info("create: {}", account);
		return repository.save(account);
	}
	
}
