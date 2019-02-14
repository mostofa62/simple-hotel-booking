package com.maestro.hotelcommerce.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="reservations")
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="from_date", columnDefinition="DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date fromDate;
	
	@Column(name="to_date", columnDefinition="DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date toDate;
	
	@ManyToOne
	@JoinColumn(name="hotel_id")
	@JsonIgnore
	private Hotel rvHotel;
	
	
}
