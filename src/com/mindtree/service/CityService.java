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
public interface CityService {

	public List<City> getAllCities() throws ServiceException;

	public City getCityByName(String cityName) throws ServiceException;

	public List<Hotel> viewAllHotels(String cityName) throws ServiceException;

}
