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

@Entity
@Table(name="rooms")
public class Room {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="name", length=100)
	@NotBlank
	private String name;
	
	@Column(columnDefinition = "TINYTEXT")
	private String description;
	
	
	@ManyToOne
	@JoinColumn(name="created_by")
	/** JsonIgone helps us to ignore infinite loop fore relational model
	 * Jackson issue
	 *  **/
	@JsonIgnore
	private User rcuser;
	
	
	
	@ManyToOne
	@JoinColumn(name="room_type_id")
	/** JsonIgone helps us to ignore infinite loop fore relational model
	 * Jackson issue
	 *  **/
	@JsonIgnore
	private RoomType roomType;
	
	
	@OneToMany(mappedBy="hrRoom")
	private Set<HotelRoom> hotelRooms;
	
	
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



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public User getRcuser() {
		return rcuser;
	}



	public void setRcuser(User rcuser) {
		this.rcuser = rcuser;
	}



	public RoomType getRoomType() {
		return roomType;
	}



	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
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
