/**
 * 
 */
package com.mindtree.dao;

import java.util.List;

import com.mindtree.exceptions.FetchException;
import com.mindtree.model.City;
import com.mindtree.model.Hotel;

/**
 * @author Ashutosh
 *
 */
public interface CityDao {

	public List<City> getAllCities() throws FetchException;

	public City getCityByName(String cityName) throws FetchException;

	public List<Hotel> viewAllHotels(String cityName) throws FetchException;

}
