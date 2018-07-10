/**
 * 
 */
package com.mindtree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.dao.CityDao;
import com.mindtree.dao.impl.CityDaoImpl;
import com.mindtree.exceptions.FetchException;
import com.mindtree.exceptions.ServiceException;
import com.mindtree.model.City;
import com.mindtree.model.Hotel;
import com.mindtree.service.CityService;

/**
 * @author Ashutosh
 *
 */
@Service
public class CityServiceImpl implements CityService {

	/* (non-Javadoc)
	 * @see com.mindtree.service.CityService#getAllCities()
	 */
	@Autowired
	private CityDao cityDao= new CityDaoImpl();

	

	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<City> getAllCities() throws ServiceException {
		try {
			return cityDao.getAllCities();
		}catch(FetchException e){
			
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public City getCityByName(String cityName) throws ServiceException {
		try {
			return cityDao.getCityByName(cityName);
		}catch(FetchException e){
			
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Hotel> viewAllHotels(String cityName) throws ServiceException {
		try{
			return cityDao.viewAllHotels(cityName);
		}catch(FetchException e){
			
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
