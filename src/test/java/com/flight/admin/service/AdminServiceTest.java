package com.flight.admin.service;



import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flight.admin.beans.AdminCredentials;
import com.flight.admin.beans.FlightDetails;
import com.flight.admin.entity.Flight;

@SpringBootTest
public class AdminServiceTest {
	
	@Autowired
	private AdminService adminService;
	
	@Test
	void addFlight() {
		FlightDetails details = new FlightDetails("ABC", "123", "DFSCD", "SDFSD", "SDC,ASA", "SDFCSD", 12, 8, "12:45", "13:50", "VEG/NON-VEG", 1200, 3000);
		Integer id = adminService.addNewFlight(details);
		assertThat(id).isInstanceOf(Integer.class);
	}
	
	@Test
	void getAvaialableFlights() throws ParseException {
		String date = "2022-06-27"; 
		String source = "Delhi";
		String destination = "Mumbai";
		List<Flight> list = adminService.getAvailableFlights(date, source, destination);
		assertThat(list).isNotEmpty();
	}
	
	@Test
	void blockAirline() {
		String airline = "abc";
		adminService.blockAirline(airline);
	}
	
	@Test
	void validateAdmin() {
		AdminCredentials cred = new AdminCredentials("admin", "admin");
		boolean b = adminService.validateAdmin(cred);
		assertThat(b).isTrue();
	}

	@Test
	void validateAdminFalse() {
		AdminCredentials cred = new AdminCredentials("admin1", "admin");
		boolean b = adminService.validateAdmin(cred);
		assertThat(b).isFalse();
	}
	
	@Test
	void flightNotAvailable() throws ParseException {
		String date = "2022-05-29"; 
		String source = "Delhi";
		String destination = "Mumbai";
		List<Flight> list = adminService.getAvailableFlights(date, source, destination);
		assertThat(list).isEmpty();;
	}
	
	@Test
	void validateAdminError() {
		AdminCredentials cred = new AdminCredentials("admin1", "admin");
		boolean b = adminService.validateAdmin(cred);
		assertThat(b).isFalse();
	}
	
	
}
