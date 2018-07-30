package com.example.demo.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	public void saveData(Customer c){
		repo.save(c);
	}
	
	@Transactional(readOnly = true)
	public String findAll(){
		List<String> mapstream;
		Stream<Customer> stream = repo.findAllCustomers();
		mapstream = stream.map(Customer::toString).collect(Collectors.toList());
		return mapstream.toString();
		
	}

	@Transactional(readOnly = true)
	public String findAllandShowByLastName() {
		List<String> mapstream;
		/*
		Stream<String> stream = repo.FindAllandShowLastName();
		mapstream = stream.map(c -> c.toString()).collect(Collectors.toList());
		return mapstream.toString();
		*/
		Stream<Customer> stream = repo.findAllCustomers();
		mapstream = stream.map(c -> c.getLastname()).collect(Collectors.toList());
		return mapstream.toString();
		
		
	}

	@Transactional(readOnly = true)
	public String findbylastname(String lastname) {
		List<String> mapstream;
		/*
		Stream<Customer> stream = repo.FindByLastName(lastname);
		mapstream = stream.map(c -> c.toString()).collect(Collectors.toList());
		return mapstream.toString();
		*/
		Stream<Customer> stream = repo.findAllCustomers();
		//System.out.println(lastname);
		Predicate<Customer> p = c -> c.getLastname().equals(lastname);
		mapstream = stream.filter(p).map(Customer::toString).collect(Collectors.toList());
		return mapstream.toString();
		
	}
	
	@Transactional(readOnly = true)
	public String findbyage(int age){
		List<String> mapstream;
		Stream<Customer> stream = repo.findAllCustomers();
		Predicate<Customer> p = c -> c.getAge() >=age;
		mapstream = stream.filter(p).map(Customer::toString).collect(Collectors.toList());
		return mapstream.toString();
	}

	@Transactional(readOnly = true)
	public String findbymonth(Month month) {
		List<String> mapstream;
		Stream<Customer> stream = repo.findAllCustomers();
		Predicate<Customer> p = c -> c.getDob().getMonth() == month;
		mapstream = stream.filter(p).map(Customer::toString).collect(Collectors.toList());
		return mapstream.toString();
	}

	@Transactional(readOnly = true)
	public String findbynoofyears(int year) {
		List<String> mapstream;
		Stream<Customer> stream = repo.findAllCustomers();
		Predicate<Customer> p = c -> (Period.between(c.getDoa(),LocalDate.now())).getYears() == year;
		mapstream = stream.filter(p).map(Customer::toString).collect(Collectors.toList());
		return mapstream.toString();
	}

	@Transactional(readOnly = true)
	public String findbyclub(String cl) {
		List<String> mapstream;
		Stream<Customer> stream = repo.findAllCustomers();
		//System.out.println(cl);
		Predicate<Customer> p = c -> c.getCl().equals(cl);
		//stream.map(c -> c.getCl()).forEach(System.out::println);
		mapstream = stream.filter(p).map(Customer::toString).collect(Collectors.toList());
		return mapstream.toString();
	}
	
}
