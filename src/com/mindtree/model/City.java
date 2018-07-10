/**
 * 
 */
package com.mindtree.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Ashutosh
 *
 */
@Entity
public class City {

	@Id
	@Column(name = "CITY_ID")
	private int id;
	
	@Column(name = "CITY_NAME")
	@NotEmpty(message = "City name cannot be empty")
	private String name;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="")
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "CITY_HOTEL",joinColumns = @JoinColumn(name = "CITY_ID"),inverseJoinColumns = @JoinColumn(name = "HOTEL_ID"))
	private Set<Hotel> hotels = new HashSet<Hotel>();

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
	 * @return the hotels
	 */
	public Set<Hotel> getHotels() {
		return hotels;
	}

	/**
	 * @param hotels the hotels to set
	 */
	public void setHotels(Set<Hotel> hotels) {
		this.hotels = hotels;
	}
	
}
