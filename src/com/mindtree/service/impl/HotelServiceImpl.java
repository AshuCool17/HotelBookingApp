/**
 * 
 */
package com.mindtree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dao.HotelDao;
import com.mindtree.exceptions.FetchException;
import com.mindtree.exceptions.PersistException;
import com.mindtree.exceptions.ServiceException;
import com.mindtree.model.City;
import com.mindtree.model.Hotel;
import com.mindtree.service.HotelService;

/**
 * @author Ashutosh
 *
 */
@Service
public class HotelServiceImpl implements HotelService {

	/* (non-Javadoc)
	 * @see com.mindtree.service.HotelService#viewAllHotels()
	 */
	@Autowired
	private HotelDao hotelDao;

	

	@Override
	public List<Hotel> getHotelsByCity(City city) throws ServiceException {
		try{
			return hotelDao.getHotelsByCity(city);
		}catch(FetchException e){
			
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void updateHotelRoomsCount(Hotel hotel) throws ServiceException {
		try{
			hotelDao.updateHotelRoomsCount(hotel);
		}catch(PersistException e){
			
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public Hotel getHotelByName(String hotelName) throws ServiceException {
		try {
			return hotelDao.getHotelByName(hotelName);
		} catch (FetchException e) {
			
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
