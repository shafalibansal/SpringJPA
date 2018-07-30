package com.example.demo.model;

public enum Club {
	
  YEAR_FIVE("Gold"),YEAR_TEN("Ruby"),YEAR_FIFTEEN("Diamond"),YEAR_TWENTY("Emerald");
	
	private final String value;
	
	private Club(String value){
		this.value=value;
	}

	public String getValue() {
		return value;
	}
	
	
	
	
}
