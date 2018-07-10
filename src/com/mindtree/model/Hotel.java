/**
 * 
 */
package com.mindtree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Ashutosh
 *
 */
@Entity
public class Hotel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HOTEL_ID")
	private int id;
	
	@Column(name = "HOTEL_NAME")
	private String name;
	
	@Column(name = "NUMBER_OF_ROOMS_AVAILABLE")
	private int roomsAvailable;
	
	@Column(name = "STAR_RATING")
	private int rating;
	
	@Column(name = "TARIFF_PER_DAY")
	private double tariff;
	
	private int totalRooms;

	/**
	 * @return the roomsAvailable
	 */
	public int getRoomsAvailable() {
		return roomsAvailable;
	}

	/**
	 * @param roomsAvailable the roomsAvailable to set
	 */
	public void setRoomsAvailable(int roomsAvailable) {
		this.roomsAvailable = roomsAvailable;
	}

	/**
	 * @return the totalRooms
	 */
	public int getTotalRooms() {
		return totalRooms;
	}

	/**
	 * @param totalRooms the totalRooms to set
	 */
	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the rooms
	 */
	public int getRooms() {
		return roomsAvailable;
	}

	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(int roomsAvailable) {
		this.roomsAvailable = roomsAvailable;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return the tariff
	 */
	public double getTariff() {
		return tariff;
	}

	/**
	 * @param tariff the tariff to set
	 */
	public void setTariff(double tariff) {
		this.tariff = tariff;
	}
	
}
