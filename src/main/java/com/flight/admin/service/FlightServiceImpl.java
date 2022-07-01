package com.flight.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.admin.entity.Flight;

@Service
public class FlightServiceImpl implements IFlightService{

	@Autowired
	private IFlightRepository repo;
	
	@Override
	public Integer saveFlight(Flight flight) {
		return repo.save(flight).getFlightID();
	}

}
