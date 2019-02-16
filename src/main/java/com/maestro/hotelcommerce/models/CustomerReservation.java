package com.maestro.hotelcommerce.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maestro.hotelcommerce.models.cores.User;

@Entity
@Table(name="customer_reservation")
public class CustomerReservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="reservation_id")
	@JsonIgnore
	private Reservation customerReservation;
	
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	@JsonIgnore
	private Customer reservaCustomer;
	
	
	@Column(name="is_contact_person", length=1, nullable=false)	
	private Byte isContactPerson;
	
	
	@ManyToOne
	@JoinColumn(name="created_by")
	/** JsonIgone helps us to ignore infinite loop fore relational model
	 * Jackson issue
	 *  **/
	@JsonIgnore
	private User customerReservaUser;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Reservation getCustomerReservation() {
		return customerReservation;
	}


	public void setCustomerReservation(Reservation customerReservation) {
		this.customerReservation = customerReservation;
	}


	public Customer getReservaCustomer() {
		return reservaCustomer;
	}


	public void setReservaCustomer(Customer reservaCustomer) {
		this.reservaCustomer = reservaCustomer;
	}


	


	public Byte getIsContactPerson() {
		return isContactPerson;
	}


	public void setIsContactPerson(Byte isContactPerson) {
		this.isContactPerson = isContactPerson;
	}


	public User getCustomerReservaUser() {
		return customerReservaUser;
	}


	public void setCustomerReservaUser(User customerReservaUser) {
		this.customerReservaUser = customerReservaUser;
	}
	
	
	
	

}
