package com.challenges.people.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class People {

	@Id
	private Long id;
	
	private String name;
	
	private String cpf;
	
	private String placeType;
	
	private String place;
	
	private String number;
	
	private String neighborhood;
	
	private String city;
	
	private String state;
	
	private String cellphone;
	
	private String telephone;

	public People() {
		super();
	}
	
	public People(Long id, String name, String cpf, String placeType, String place, String number, String neighborhood,
			String city, String state, String cellphone, String telephone) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.placeType = placeType;
		this.place = place;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.cellphone = cellphone;
		this.telephone = telephone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
