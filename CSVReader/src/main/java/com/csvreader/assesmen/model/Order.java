package com.csvreader.assesmen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ORDERPROCESSOR")
public class Order {

	@Id
	@Column(name ="ID")
	private Long id;
	
	@NotEmpty

	@Column(name ="CLIENT_NAME")
	private String clientName;
	
	@NotEmpty

	@Column(name ="PHONE_NUMBER")
	private String phoneNumber;
	
	@NotEmpty

	@Column(name ="EMAIL")
	private String email;
	
	@NotEmpty

	@Column(name ="PARCEL_WEIGHT")
	private float parcelWeight;
	
	@NotEmpty

	@Column(name ="COUNTRY")
	private String country;

	
	
	// getter Setter For Order
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getParcelWeight() {
		return parcelWeight;
	}

	public void setParcelWeight(float parcelWeight) {
		this.parcelWeight = parcelWeight;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	// Default Constructor
	
	public Order(String id2, String email2, String phoneNumber2, double parcelWeight2, String country2) {
		super();
	}
	
	// parametrised Constructor
	public Order(Long id, String clientName, String phoneNumber, String email, float parcelWeight, String country) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.parcelWeight = parcelWeight;
		this.country = country;
	}
	
	
   // To String Method of Object Class
	@Override
	public String toString() {
		return "Order [id=" + id + ", clientName=" + clientName + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", parcelWeight=" + parcelWeight + ", country=" + country + "]";
	}

	
	
	
	
	
	
	
	
}
