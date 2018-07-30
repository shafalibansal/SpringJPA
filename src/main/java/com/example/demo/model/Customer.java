package com.example.demo.model;


import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Customer",schema = "springjpa")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="age")
	private int age;
	
	@Column(name = "dob")
	private LocalDate dob;
	
	@Column(name="associationdate")
	private LocalDate doa;
	
	@Column(name = "Club")
	public String cl;
	
	public String getCl(){
		return cl;
	}
	
	public void setCl(LocalDate date){
		Period p = Period.between(date,LocalDate.now());
		int val = p.getYears();
		if(val >=5 && val <10){
			this.cl = Club.YEAR_FIVE.getValue();
		}
		else if(val >=10 && val <15){
			this.cl = Club.YEAR_TEN.getValue();
		}
		else if(val >=15 && val <20){
			this.cl = Club.YEAR_FIFTEEN.getValue();
		}
		else if(val >=20){
			this.cl = Club.YEAR_TWENTY.getValue();
		}
		else if(val < 5){
			this.cl = "None";
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(LocalDate date) {
		Period p = Period.between(date, LocalDate.now());
		this.age = p.getYears();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDoa() {
		return doa;
	}

	public void setDoa(LocalDate doa) {
		this.doa = doa;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" +age + ",dob=" + dob + ", association_date="+doa+"]";
	}

	public Customer(String firstname, String lastname,LocalDate dob,LocalDate doa) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.setAge(dob);
		this.age = getAge();
		this.doa = doa;
		this.setCl(doa);
		this.cl = getCl();
		
	}
	
	protected Customer(){}
	
}
