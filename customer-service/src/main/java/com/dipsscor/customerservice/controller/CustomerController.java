package com.dipsscor.customerservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.dipsscor.customerservice.model.Account;
import com.dipsscor.customerservice.model.Customer;
import com.dipsscor.customerservice.repository.CustomerRepository;
import com.dipsscor.customerservice.utils.CustomerMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerRepository repository;
	@Autowired
    private WebClient.Builder webClientBuilder;

	@GetMapping("/customer/{id}")
	public Mono<Customer> findById(@PathVariable("id") String id) {
		LOGGER.info("findById: id={}", id);
		return repository.findById(id);
	}

	@GetMapping("/customer")
	public Flux<Customer> findAll() {
		LOGGER.info("findAll");
		return repository.findAll();
	}

	@GetMapping("/customer/{id}/with-accounts")
	public Mono<Customer> findByIdWithAccounts(@PathVariable("id") String id) {
		LOGGER.info("findByIdWithAccounts: id={}", id);
		Flux<Account> accounts = webClientBuilder.build().get().uri("http://account-service/account/customer-Id/{customer}", id).retrieve().bodyToFlux(Account.class);		
		return accounts
				.collectList()
				.map(a -> new Customer(a))
				.mergeWith(repository.findById(id))
				.collectList()
				.map(CustomerMapper::map);
	}

	@PostMapping("/customer")
	public Mono<Customer> create(@RequestBody Customer customer) {
		LOGGER.info("create: {}", customer);
		return repository.save(customer);
	}
	
}
