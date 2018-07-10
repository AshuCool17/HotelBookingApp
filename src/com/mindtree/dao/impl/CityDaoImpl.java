/**
 * 
 */
package com.mindtree.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.mindtree.comparator.HotelComparator;
import com.mindtree.dao.CityDao;
import com.mindtree.exceptions.FetchException;
import com.mindtree.model.City;
import com.mindtree.model.Hotel;
import com.mindtree.util.HibernateUtil;

/**
 * @author Ashutosh
 *
 */
@Repository("cityDao")
public class CityDaoImpl implements CityDao {

	/* (non-Javadoc)
	 * @see com.mindtree.dao.CityDao#getAllCities()
	 */

	

	@Override
	public List<City> getAllCities() throws FetchException {

		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(City.class);
		try{
			@SuppressWarnings("unchecked")
			List<City> cities = criteria.list();
			return cities;
		}catch(DataAccessException e){
			
			throw new FetchException(e.getMessage(), e);
		}
	}

	@Override
	public City getCityByName(String cityName) throws FetchException {
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(City.class);
		criteria.add(Restrictions.eq("name", cityName));
		try{
			@SuppressWarnings("unchecked")
			List<City> cities = criteria.list();
			if(CollectionUtils.isEmpty(cities)){
				return null;
			}
			return cities.get(0);
		}catch(DataAccessException e){
			
			throw new FetchException(e.getMessage(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Hotel> viewAllHotels(String cityName) throws FetchException {

		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(City.class);
		criteria.add(Restrictions.eq("name", cityName));
		try{
			List<City> cities = criteria.list();
			if(CollectionUtils.isEmpty(cities)){
				return null;
			}
			List<Hotel> hotels = new ArrayList<Hotel>();
			hotels.addAll(cities.get(0).getHotels());
			Collections.sort(hotels,new HotelComparator());
			hotels = hotels.stream().limit(5).collect(Collectors.toList());
			return hotels;
		}catch(DataAccessException e){
			
			throw new FetchException(e.getMessage(), e);
		}
	}

}
