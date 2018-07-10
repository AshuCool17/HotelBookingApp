/**
 * 
 */
package com.mindtree.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mindtree.model.Booking;

/**
 * @author Ashutosh
 *
 */
@Component
public class BookingValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Booking.class);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "checkinDate", "error.checkin_Date.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "checkoutDate", "error.checkout_Date.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberOfRoomsRequired", "error.numberOfRoomsRequired.required");
		
		if(arg0 instanceof Booking){
			Booking b = (Booking) arg0;
			if(b.getCheckinDate() != null && b.getCheckoutDate() != null && b.getCheckoutDate().before(b.getCheckinDate())){
				errors.rejectValue("checkoutDate", "error.checkout_Date.invalid");
			}
			if(null != b.getCityName() && b.getCityName().equals("-1")){
				errors.rejectValue("cityName", "error.city.required");
			}
			if(null != b.getHotelName()&& b.getHotelName().equals("-1")){
				errors.rejectValue("hotelName", "error.hotel.required");
			}
			if(b.getNumberOfRooms() <= 0){
				errors.rejectValue("numberOfRooms", "error.numberOfRooms.invalid");
			}
		}
	}

}
