package com.mindtree.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mindtree.dao.BookingDAO;
import com.mindtree.exceptions.PersistException;
import com.mindtree.model.Booking;
import com.mindtree.util.HibernateUtil;

@Repository("bookingDAO")
public class BookingDAOImpl implements BookingDAO {

	

	@Override
	public void persistBooking(Booking booking) throws PersistException{

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.persist(booking);
		}catch(DataAccessException e){
			
			throw new PersistException(e.getMessage(), e);
		}
		finally{
			transaction.commit();
		}

	}

}
