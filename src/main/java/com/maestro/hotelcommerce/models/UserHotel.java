package com.maestro.hotelcommerce.models;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.maestro.hotelcommerce.models.cores.User;
import com.maestro.hotelcommerce.models.keys.UserHotelKey;


/** 
 * Example of Composite Primary key
 * 
 * **/

@Entity
@Table(name="user_hotel")
public class UserHotel {
	
	
	@EmbeddedId
	UserHotelKey id;
	
	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name="user_id")
	User huser;
	
	@ManyToOne
	@MapsId("hotel_id")
	@JoinColumn(name="hotel_id")
	Hotel uhotel;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)	
	@Column(name = "created_at", nullable=false, updatable=false)
	private Date createdAt;
	
	
	
	
	@UpdateTimestamp
	@Column(name="updated_at", nullable=true, updatable=true)
	private LocalDateTime updatedAt;




	public UserHotelKey getId() {
		return id;
	}




	public void setId(UserHotelKey id) {
		this.id = id;
	}




	




	public User getHuser() {
		return huser;
	}




	public void setHuser(User huser) {
		this.huser = huser;
	}




	public Hotel getUhotel() {
		return uhotel;
	}




	public void setUhotel(Hotel uhotel) {
		this.uhotel = uhotel;
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
