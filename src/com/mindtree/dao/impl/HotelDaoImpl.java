/**
 * 
 */
package com.mindtree.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.mindtree.dao.HotelDao;
import com.mindtree.exceptions.FetchException;
import com.mindtree.exceptions.PersistException;
import com.mindtree.model.City;
import com.mindtree.model.Hotel;
import com.mindtree.util.HibernateUtil;

/**
 * @author Ashutosh
 *
 */
@Repository("hotelDao")
public class HotelDaoImpl implements HotelDao {

	/* (non-Javadoc)
	 * @see com.mindtree.dao.HotelDao#viewAllHotels()
	 */

	

	@Override
	public List<Hotel> getHotelsByCity(City city) throws FetchException {
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(Hotel.class);
		criteria.createAlias("city.name", "cityName");
		criteria.add(Restrictions.eq("cityName", city.getName()));
		criteria.add(Restrictions.gt("roomsAvailable", 0)); //not to display rooms if not available
		try{
			@SuppressWarnings({ "unchecked" })
			List<Hotel> hotels = criteria.list();
			return hotels;
		}catch(DataAccessException e){
			
			throw new FetchException(e.getMessage(), e);
		}
	}

	@Override
	public void updateHotelRoomsCount(Hotel hotel) throws PersistException {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.saveOrUpdate(hotel);
		}catch(DataIntegrityViolationException ex) {
			//logger.debug(ex.getMessage());
			throw new PersistException(ex.getMessage(), ex);
		}catch (DataAccessException e) {
			
			throw new PersistException(e.getMessage(), e);
		} 
		finally{
			transaction.commit();
		}
	}

	@Override
	public Hotel getHotelByName(String hotelName) throws FetchException {
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(Hotel.class);
		criteria.add(Restrictions.eq("name", hotelName));
		try{
			@SuppressWarnings("unchecked")
			List<Hotel> hotels = criteria.list();
			return hotels.get(0);
		}catch(DataAccessException e){
			
			throw new FetchException(e.getMessage(), e);
		}
	}

}
