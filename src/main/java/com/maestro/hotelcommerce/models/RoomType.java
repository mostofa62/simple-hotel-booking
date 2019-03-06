package com.maestro.hotelcommerce.models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maestro.hotelcommerce.models.cores.User;
import com.maestro.hotelcommerce.models.validators.annotations.ManyToOneRequired;

@Entity
@Table(name="room_types")

public class RoomType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name="name", length=50)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="created_by")
	/** JsonIgone helps us to ignore infinite loop fore relational model
	 * Jackson issue
	 *  **/
	@JsonIgnore
	private User rtuser;
	
	
	@ManyToOne
	@JoinColumn(name="hotel_id")
	@JsonIgnore
	
	@ManyToOneRequired
	private Hotel rthotel;
	
	
	@OneToMany(mappedBy="roomType")
	@JsonIgnore
	private Set<Room> rooms;
	
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public User getRtuser() {
		return rtuser;
	}


	public void setRtuser(User rtuser) {
		this.rtuser = rtuser;
	}


	public Hotel getRthotel() {
		return rthotel;
	}


	public void setRthotel(Hotel rthotel) {
		this.rthotel = rthotel;
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


	public Set<Room> getRooms() {
		return rooms;
	}


	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
	
	
	
	
}
