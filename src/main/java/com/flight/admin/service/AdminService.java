package com.flight.admin.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.admin.beans.AdminCredentials;
import com.flight.admin.beans.FlightDetails;
import com.flight.admin.entity.Flight;
@Service
public class AdminService {
	
@Autowired
private FlightServiceImpl flightService;

@Autowired
private IFlightRepository flightRepo;

	public Integer addNewFlight(FlightDetails flightDetails) {
	Flight flight = new Flight(flightDetails.getAirline(),flightDetails.getFlightNumber(),flightDetails.getSource(),flightDetails.getDestination(),flightDetails.getDays(),flightDetails.getInstrumentsUsed(),flightDetails.getEconomySeats(),flightDetails.getBusinessSeats(),flightDetails.getDepartureTime(),flightDetails.getArrivalTime(),flightDetails.getMeals(),true,flightDetails.getEconomySeatsPrice(),flightDetails.getBusinessSeatsPrice());
	Integer flightID = flightService.saveFlight(flight);
	return flightID;
	}
	
	public void blockAirline(String airline) {
		flightRepo.blockAirline(airline);
	}
	
	public List<Flight> getAvailableFlights(String date, String source, String destination) throws ParseException{
		String day = getDayFromDate(date);
		return flightRepo.getAvailableFlights(day, source, destination);
	}
	
	private String getDayFromDate(String date) throws ParseException {
		  SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		  Date dt1 = format1.parse(date);
		  DateFormat format2 = new SimpleDateFormat("EEEE"); 
		  String finalDay = format2.format(dt1);
		  return finalDay;
	}
	
	public boolean validateAdmin(AdminCredentials adminCredentials) {
		return (adminCredentials.getUserName().equals("admin") && adminCredentials.getPassWord().equals("admin"));
	}
}
