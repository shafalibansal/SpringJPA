package com.example.demo.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.example.demo.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Long>{

	
	@Query("Select c from Customer c")
	Stream<Customer> findAllCustomers();
	/*
	@Query("Select c.lastname from Customer c")
	Stream<String> FindAllandShowLastName();
	
	@Query("Select c from Customer c where c.lastname=?1")
	Stream<Customer> FindByLastName(String lastname);
*/
}
