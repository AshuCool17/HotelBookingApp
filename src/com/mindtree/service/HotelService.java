/**
 * 
 */
package com.mindtree.service;

import java.util.List;

import com.mindtree.exceptions.ServiceException;
import com.mindtree.model.City;
import com.mindtree.model.Hotel;

/**
 * @author Ashutosh
 *
 */
public interface HotelService {

	public List<Hotel> getHotelsByCity(City city) throws ServiceException;

	public void updateHotelRoomsCount(Hotel hotel) throws ServiceException;

	public Hotel getHotelByName(String hotelName) throws ServiceException;

}
