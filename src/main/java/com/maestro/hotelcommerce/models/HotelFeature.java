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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="hotel_feature")
public class HotelFeature {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	
	
	
	@ManyToOne
	@JoinColumn(name="hotel_id")
	@JsonIgnore
	private Hotel fhotel;
	
	
	@ManyToOne
	@JoinColumn(name="feature_id")
	@JsonIgnore
	private Feature hfeature;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)	
	@Column(name = "created_at", nullable=false, updatable=false)
	private Date createdAt;
	
	
		
	@UpdateTimestamp
	@Column(name="updated_at", nullable=true, updatable=true)
	private LocalDateTime updatedAt;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Hotel getFhotel() {
		return fhotel;
	}



	public void setFhotel(Hotel fhotel) {
		this.fhotel = fhotel;
	}



	public Feature getHfeature() {
		return hfeature;
	}



	public void setHfeature(Feature hfeature) {
		this.hfeature = hfeature;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
	
	
}
