package com.maestro.hotelcommerce.models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
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
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="hotels")
public class Hotel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotEmpty
	@NotBlank(message = "Name is mandatory")
	@Column(name="name", length=100)
	private String name;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	/** JsonIgone helps us to ignore infinite loop fore relational model
	 * Jackson issue
	 *  **/
	@JsonIgnore
	private Hotel hotel;
	
	@OneToMany(mappedBy="hotel")
	/**
	 * A hotel may have 0 or more child Hotel
	 * mappedBy will look for single declared model like[ Hotel hotel ]
	 */
	private Set<Hotel> childHotels = new HashSet<Hotel>();
	
	
	@OneToMany(mappedBy="uhotel")
	/**
	 * User To Hotel
	 * will lookup for Hotel uhotel in UserHotel model class
	 */
	private Set<UserHotel> userHotels;
	
	
	@OneToMany(mappedBy="fhotel")
	/**
	 * Feature to Hotel
	 * will lookup for Hotel fhotel in HotelFeature model
	 */
	private Set<HotelFeature> hotelFeatures;
	
	@OneToMany(mappedBy="hrHotel")
	private Set<HotelRoom> hotelRooms;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)	
	@Column(name = "created_at", nullable=false, updatable=false)
	private Date createdAt;
	
	
	
	
	@UpdateTimestamp
	@Column(name="updated_at", nullable=true, updatable=true)
	private LocalDateTime updatedAt;
	
	/**
	 * 
	 * Temporary for testing curl purpose not inserted in table
	 * 
	 */
	
	@Column(name="parent_id", insertable=false, updatable=false)
	private Long parentId;
	
	


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


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public Set<Hotel> getChildHotels() {
		return childHotels;
	}


	public void setChildHotels(Set<Hotel> childHotels) {
		this.childHotels = childHotels;
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


	public Long getParentId() {
		return parentId;
	}


	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}


	public Set<UserHotel> getUserHotels() {
		return userHotels;
	}


	public void setUserHotels(Set<UserHotel> userHotels) {
		this.userHotels = userHotels;
	}


	public Set<HotelFeature> getHotelFeatures() {
		return hotelFeatures;
	}


	public void setHotelFeatures(Set<HotelFeature> hotelFeatures) {
		this.hotelFeatures = hotelFeatures;
	}
	
	
	
	
	
	
	

}
