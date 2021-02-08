package com.example.springbootmybatis2.model;

import org.springframework.stereotype.Component;

@Component
public class Country {
	private Long id;
	private String countryname;
	private String countrycode;

	public Country() {
		System.out.println("-------Country----init--");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

}
