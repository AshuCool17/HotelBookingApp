/**
 * 
 */
package com.mindtree.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.exceptions.ServiceException;
import com.mindtree.model.Booking;
import com.mindtree.model.City;
import com.mindtree.model.Hotel;
import com.mindtree.service.BookingService;
import com.mindtree.service.CityService;
import com.mindtree.service.HotelService;
import com.mindtree.validator.BookingValidator;

/**
 * @author Ashutosh
 *
 */
@Controller
public class HomeController {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(value = {"/","/home"},method = RequestMethod.GET)
	public String gotoHomePage(){
		return "home";
	}
	
	@RequestMapping(value = "/view",method = RequestMethod.GET)
	public String viewAllHotels(Model model, Locale locale){
		try{
		List<City> city = cityService.getAllCities();
		model.addAttribute("cities", city);
		model.addAttribute("cityName", new String());
		}catch (ServiceException e) {
			
			model.addAttribute("errorMessage", messageSource.getMessage(
					"hotel.get.error", null, "Unable to view hotels", locale));
		}
		return null;
	}
	
	@RequestMapping(value = "/book",method = RequestMethod.GET)
	public String getAllCities(Model model, Locale locale){
		try{
		List<City> city = cityService.getAllCities();
		model.addAttribute("cities", city);
		model.addAttribute("booking", new Booking());
		model.addAttribute("cityName",new String());
		return "bookHotel";
		}catch (ServiceException e) {
			
			model.addAttribute("errorMessage", messageSource.getMessage(
					"hotel.get.error", null, "Unable to view hotels", locale));
		}
		return null;
	}
	
	@RequestMapping(value="/getHotel", produces="application/json")
	public @ResponseBody Set<Hotel> getAllHotelsInACity(@RequestParam("city") String cityName, Model model, Locale locale){
		try{
		City cityObj = cityService.getCityByName(cityName);
		Set<Hotel> hotels = new HashSet<Hotel>();
		if(cityObj!=null)
		hotels.addAll(cityObj.getHotels());
		model.addAttribute("hotels",hotels);
	    return hotels;
		}catch (ServiceException e) {
			
			model.addAttribute("errorMessage", messageSource.getMessage(
					"hotel.get.error", null, "Unable to view hotels", locale));
		}
		return null;
	}
	
	@RequestMapping(value="/bookHotel", method = RequestMethod.POST)
	public String bookRoom(@ModelAttribute("booking") Booking booking,BindingResult result,ModelMap model, Locale locale){

		String page = "home";
		BookingValidator bookingValidator = new BookingValidator();
		if(bookingValidator.supports(Booking.class)){
			bookingValidator.validate(booking, result);
			if(result.hasErrors()){
				List<City> city;
				try {
					city = cityService.getAllCities();
					model.addAttribute("cities", city);
					model.addAttribute("cityName",booking.getCityName());
				} catch (ServiceException e) {
					
					model.addAttribute("errorMessage", messageSource.getMessage(
							"hotel.get.error", null, "Unable to view hotels", locale));
				}
				
				City cityObj;
				try {
					cityObj = cityService.getCityByName(booking.getCityName());
					Set<Hotel> hotels = new HashSet<Hotel>();
					if(cityObj!=null)
					hotels.addAll(cityObj.getHotels());
					model.addAttribute("hotelsOfCity",hotels);
					return "bookHotel";
				} catch (ServiceException e) {
					
					model.addAttribute("errorMessage", messageSource.getMessage(
							"hotel.get.error", null, "Unable to view hotels", locale));
				}
			}else{
				Hotel hotel;
				try {
					hotel = hotelService.getHotelByName(booking.getHotelName());
					if(booking.getNumberOfRooms() <= hotel.getRoomsAvailable()){
						bookingService.persistBooking(booking);
						hotel.setRoomsAvailable(hotel.getRoomsAvailable() - booking.getNumberOfRooms());
						hotelService.updateHotelRoomsCount(hotel);
						model.addAttribute("message", messageSource.getMessage(
								"success.booking.add",
								new Object[] { booking.getId() },
								"Booking with reference id " + booking.getId() + " created successfully with the total amount Rs. " +booking.getNumberOfRooms()*hotel.getTariff() ,
								locale));
				}else{
					model.addAttribute("errorMessage", messageSource.getMessage(
							"error.booking.add",
							new Object[] { booking.getId()},
							"error.booking.add", locale));
				}
				}catch (ServiceException e) {
					model.addAttribute("errorMessage", messageSource.getMessage(
							"error.booking.add",
							new Object[] { booking.getId()},
							"error.booking.add", locale));
				}
				
			}
		}
		return page;
	}
	
	@RequestMapping("/viewAllHotels")
	public @ResponseBody List<Hotel> viewAllHotels(@RequestParam("city") String cityName, Locale locale, Model model){
		List<Hotel> hotels = new ArrayList<Hotel>();
		try {
			if(!CollectionUtils.isEmpty(cityService.viewAllHotels(cityName))){
				hotels.addAll(cityService.viewAllHotels(cityName));
				model.addAttribute("hotels", hotels);
				return hotels;
			}
		} catch (ServiceException e) {
			
			model.addAttribute("errorMessage", messageSource.getMessage(
					"hotel.get.error", null, "Unable to view hotels", locale));
		}
		return hotels;
		
	}

}
