package com.flight.admin.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.flight.admin.service.IFlightRepository;

@SpringBootTest
public class FlightRepository {
	
	@Autowired
	private IFlightRepository repo;
	
	@Test
	void blockAirline() {
		String airline = "abc";
		repo.blockAirline(airline);
	}

}
