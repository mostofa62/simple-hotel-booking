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
import com.maestro.hotelcommerce.models.cores.User;

@Entity
@Table(name="hotel_room")
public class HotelRoom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name="created_by")
	@JsonIgnore
	private User hrUser;
	
	@ManyToOne
	@JoinColumn(name="hotel_id")
	@JsonIgnore
	private Hotel hrHotel;
	
	
	@ManyToOne
	@JoinColumn(name="room_id")
	@JsonIgnore
	private Room hrRoom;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at",nullable=false, updatable=false)
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

	public User getHrUser() {
		return hrUser;
	}

	public void setHrUser(User hrUser) {
		this.hrUser = hrUser;
	}

	public Hotel getHrHotel() {
		return hrHotel;
	}

	public void setHrHotel(Hotel hrHotel) {
		this.hrHotel = hrHotel;
	}

	public Room getHrRoom() {
		return hrRoom;
	}

	public void setHrRoom(Room hrRoom) {
		this.hrRoom = hrRoom;
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
