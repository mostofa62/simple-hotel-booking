package com.maestro.hotelcommerce.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="customers")
public class Customer {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="title", length=3)
	private String title;
		
	
	@Column(name="first_name", length=35)
	@NotBlank
	private String firstName;
	
	@Column(name="last_name", length=35)
	@NotBlank
	private String lastName;
	
	
	
	@Column(name="date_of_birth",columnDefinition="DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	
	
	@OneToOne
	@JoinColumn(name="address_id", referencedColumnName="id")
	private Address address;
	
	
}
