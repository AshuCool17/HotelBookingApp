/**
 * 
 */
package com.mindtree.dao;

import java.util.List;

import com.mindtree.exceptions.FetchException;
import com.mindtree.exceptions.PersistException;
import com.mindtree.model.City;
import com.mindtree.model.Hotel;

/**
 * @author Ashutosh
 *
 */
public interface HotelDao {

	public List<Hotel> getHotelsByCity(City city) throws FetchException;

	public void updateHotelRoomsCount(Hotel hotel) throws PersistException;

	public Hotel getHotelByName(String hotelName) throws FetchException;

}
