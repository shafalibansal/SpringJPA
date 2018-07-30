package com.example.demo.controller;


import java.time.LocalDate;
import java.time.Month;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired 
	private CustomerService service;
	
	@RequestMapping(name="/save",method=RequestMethod.POST)
	public String saveCustomer(){
		
		service.saveData(new Customer("Shweta","Garg",LocalDate.of(1994,Month.MAY, 18),LocalDate.of(2004,Month.OCTOBER, 15)));
		service.saveData(new Customer("Swati","Jha",LocalDate.of(1992,Month.NOVEMBER, 19),LocalDate.of(2014,Month.MAY,20)));
		service.saveData(new Customer("Manish","Garg",LocalDate.of(1993,Month.APRIL, 18),LocalDate.of(2010,Month.DECEMBER, 18)));
		service.saveData(new Customer("Bhavya","Pasricha",LocalDate.of(1993,Month.SEPTEMBER,23),LocalDate.of(2012,Month.JANUARY, 8)));
		service.saveData(new Customer("Badal","Vig",LocalDate.of(1993,Month.NOVEMBER,29),LocalDate.of(2008,Month.FEBRUARY, 29)));
		return "Done";
	}
	
	
	@RequestMapping("/findall")
	public String findAllbyStream(){
		return service.findAll();
	}
	
	
	@RequestMapping("/findallandshowlastname")
	public String findAllandShowByLastName(){
		return service.findAllandShowByLastName();
	}
	

	@RequestMapping("/findbylastname/{lastname}")
	public String findByLastName(@PathVariable String lastname){
		return service.findbylastname(lastname);
	}
	
	
	@RequestMapping("/findbyagegroup/{age}")
	public String findbyage(@PathVariable int age){
		return service.findbyage(age);
	
	}
	
	@RequestMapping("/findbirthdaybymonth/{month}")
	public String findbirthdaybymonth(@PathVariable Month month){
		return service.findbymonth(month);
	
	}
	
	@RequestMapping("/findbynoofyears/{year}")
	public String findbyassociatedyears(@PathVariable int year){
		return service.findbynoofyears(year);

	}
	
	@RequestMapping("/findbyClub/{cl}")
    public String findbyClub(@PathVariable String cl){
		return service.findbyclub(cl);
	}
	

}
