package com.flight.admin.beans;

public class FlightDetails {
	private String airline;
	private String flightNumber;
	private String source;
	private String destination;
	private String days;
	private String instrumentsUsed;
	private Integer economySeats;
	private Integer businessSeats;
	private String departureTime;
	private String arrivalTime;
	private String meals;
	private Integer economySeatsPrice;
	private Integer businessSeatsPrice;
	public FlightDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FlightDetails(String airline, String flightNumber, String source, String destination, String days,
			String instrumentsUsed, Integer economySeats, Integer businessSeats, String departureTime,
			String arrivalTime, String meals, Integer economySeatsPrice, Integer businessSeatsPrice) {
		super();
		this.airline = airline;
		this.flightNumber = flightNumber;
		this.source = source;
		this.destination = destination;
		this.days = days;
		this.instrumentsUsed = instrumentsUsed;
		this.economySeats = economySeats;
		this.businessSeats = businessSeats;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.meals = meals;
		this.economySeatsPrice = economySeatsPrice;
		this.businessSeatsPrice = businessSeatsPrice;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getInstrumentsUsed() {
		return instrumentsUsed;
	}
	public void setInstrumentsUsed(String instrumentsUsed) {
		this.instrumentsUsed = instrumentsUsed;
	}
	public Integer getEconomySeats() {
		return economySeats;
	}
	public void setEconomySeats(Integer economySeats) {
		this.economySeats = economySeats;
	}
	public Integer getBusinessSeats() {
		return businessSeats;
	}
	public void setBusinessSeats(Integer businessSeats) {
		this.businessSeats = businessSeats;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getMeals() {
		return meals;
	}
	public void setMeals(String meals) {
		this.meals = meals;
	}
	public Integer getEconomySeatsPrice() {
		return economySeatsPrice;
	}
	public void setEconomySeatsPrice(Integer economySeatsPrice) {
		this.economySeatsPrice = economySeatsPrice;
	}
	public Integer getBusinessSeatsPrice() {
		return businessSeatsPrice;
	}
	public void setBusinessSeatsPrice(Integer businessSeatsPrice) {
		this.businessSeatsPrice = businessSeatsPrice;
	}
}
