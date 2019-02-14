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
@Table(name="features")
public class Feature {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name="name", length=100)
	private String name;
	
	
	@Column(columnDefinition = "TINYTEXT")
	private String description;
	
	/**
	 * 
	 * Temporary for testing curl purpose not inserted in table
	 * 
	 */	
	@Column(name="created_by",insertable=false, updatable=false)
	private Long userId;
	
	@ManyToOne
	@JoinColumn(name="created_by")
	/** JsonIgone helps us to ignore infinite loop fore relational model
	 * Jackson issue
	 *  **/
	@JsonIgnore
	private User user;
	
	
	@OneToMany(mappedBy="hfeature")
	/**
	 * Hotel to Feature
	 * will look up for Hotel hfeature in HotelFeature
	 */
	private Set<HotelFeature> hotelFeatures;
	
	
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<HotelFeature> getHotelFeatures() {
		return hotelFeatures;
	}

	public void setHotelFeatures(Set<HotelFeature> hotelFeatures) {
		this.hotelFeatures = hotelFeatures;
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
