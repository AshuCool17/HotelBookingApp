package com.mindtree.dao;

import com.mindtree.exceptions.PersistException;
import com.mindtree.model.Booking;


public interface BookingDAO {

	public void persistBooking(Booking booking) throws PersistException;

}
