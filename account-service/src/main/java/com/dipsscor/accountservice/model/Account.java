package com.dipsscor.accountservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document
@Data

public class Account {
	

	@Id
	private String id;
	
	private String number;
	
	private String customerId;
	
	private int amount;


}
