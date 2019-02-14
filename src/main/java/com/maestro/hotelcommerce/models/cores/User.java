package com.maestro.hotelcommerce.models.cores;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.maestro.hotelcommerce.models.Room;
import com.maestro.hotelcommerce.models.UserHotel;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Name is Required!")
	@Column(name="name", length=30)
	private String name;
	
	
	@OneToMany(mappedBy="huser")
	private Set<UserHotel> userHotels;
	
	
	@OneToMany(mappedBy="rcuser")
	private Set<Room> userCRooms;
	
	@Column(name="status", length=1)
	private Byte status;
	

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

	public Set<UserHotel> getUserHotels() {
		return userHotels;
	}

	public void setUserHotels(Set<UserHotel> userHotels) {
		this.userHotels = userHotels;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	

	
	
	
	
}
