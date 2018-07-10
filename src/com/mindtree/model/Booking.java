/**
 * 
 */
package com.mindtree.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Ashutosh
 *
 */
/*
 * Entity class
 */
@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date checkinDate;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date checkoutDate;
	
	@Column(name = "NUMBER_OF_ROOMS")
	private int numberOfRoomsRequired;
	
	@Column(name = "HOTEL_NAME")
	private String hotelName;
	
	@Column(name = "CITY_NAME")
	private String cityName;

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
	 * @return the checkin_Date
	 */
	public Date getCheckinDate() {
		return checkinDate;
	}

	/**
	 * @param checkin_Date the checkin_Date to set
	 */
	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	/**
	 * @return the checkout_Date
	 */
	public Date getCheckoutDate() {
		return checkoutDate;
	}

	/**
	 * @param checkout_Date the checkout_Date to set
	 */
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	/**
	 * @return the numberOfRooms
	 */
	public int getNumberOfRooms() {
		return numberOfRoomsRequired;
	}

	/**
	 * @param numberOfRooms the numberOfRooms to set
	 */
	public void setNumberOfRooms(int numberOfRoomsRequired) {
		this.numberOfRoomsRequired = numberOfRoomsRequired;
	}

	/**
	 * @return the numberOfRoomsRequired
	 */
	public int getNumberOfRoomsRequired() {
		return numberOfRoomsRequired;
	}

	/**
	 * @param numberOfRoomsRequired the numberOfRoomsRequired to set
	 */
	public void setNumberOfRoomsRequired(int numberOfRoomsRequired) {
		this.numberOfRoomsRequired = numberOfRoomsRequired;
	}

	/**
	 * @return the hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * @param hotelName the hotelName to set
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}



	
}
