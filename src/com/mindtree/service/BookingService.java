package com.mindtree.service;

import com.mindtree.exceptions.ServiceException;
import com.mindtree.model.Booking;

public interface BookingService {

	public void persistBooking(Booking booking) throws ServiceException;

}
