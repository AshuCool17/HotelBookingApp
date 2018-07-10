package com.mindtree.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dao.BookingDAO;
import com.mindtree.exceptions.PersistException;
import com.mindtree.exceptions.ServiceException;
import com.mindtree.model.Booking;
import com.mindtree.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	
	
	@Autowired
	private BookingDAO bookingDAO;
	
	@Override
	public void persistBooking(Booking booking) throws ServiceException {
       	try {
			bookingDAO.persistBooking(booking);
		}catch(PersistException e){
			
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
