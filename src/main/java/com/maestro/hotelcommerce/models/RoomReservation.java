package com.maestro.hotelcommerce.models;

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
@Table(name="room_reservation")
public class RoomReservation {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name="room_id")
	@JsonIgnore
	private Room reservaRoom;
	
	
	@ManyToOne
	@JoinColumn(name="reservation_id")
	@JsonIgnore
	private Reservation roomReservation;
	
	
	@ManyToOne
	@JoinColumn(name="created_by")
	/** JsonIgone helps us to ignore infinite loop fore relational model
	 * Jackson issue
	 *  **/
	@JsonIgnore
	private User roomReservaUser;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Room getReservaRoom() {
		return reservaRoom;
	}


	public void setReservaRoom(Room reservaRoom) {
		this.reservaRoom = reservaRoom;
	}


	public Reservation getRoomReservation() {
		return roomReservation;
	}


	public void setRoomReservation(Reservation roomReservation) {
		this.roomReservation = roomReservation;
	}


	public User getRoomReservaUser() {
		return roomReservaUser;
	}


	public void setRoomReservaUser(User roomReservaUser) {
		this.roomReservaUser = roomReservaUser;
	}
	
	
	
	
}
