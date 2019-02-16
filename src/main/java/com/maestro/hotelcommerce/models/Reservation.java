package com.maestro.hotelcommerce.models;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)	
	@Column(name = "created_at", nullable=false, updatable=false)
	private Date createdAt;
	
		
	
	@UpdateTimestamp
	@Column(name="updated_at", nullable=true, updatable=true)
	private LocalDateTime updatedAt;
	
	
}
