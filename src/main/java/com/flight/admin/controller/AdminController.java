package com.flight.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.admin.beans.AdminCredentials;
import com.flight.admin.beans.FlightDetails;
import com.flight.admin.entity.Flight;
import com.flight.admin.service.AdminService;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
	
@Autowired
AdminService adminService;
	@CrossOrigin
	@PostMapping("/addFlight")
	public ResponseEntity<Integer> addNewFlight(@RequestBody FlightDetails flightDetails){
		Integer flightId  = null;
		try {
			flightId = adminService.addNewFlight(flightDetails);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(flightId,HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<Integer> addNewFlight(@RequestBody AdminCredentials adminCredentials){
		Integer success  = 0;
		try {
			boolean isSuceess = adminService.validateAdmin(adminCredentials);
			if(isSuceess) {
				success = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(success,HttpStatus.OK);
	}
	
	@PutMapping("/blockAirline/{airline}")
	public ResponseEntity<String> blockAirline(@PathVariable String airline){
		try {
			adminService.blockAirline(airline);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("cannot block flight -- server error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(airline + " is now blocked",HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/getAvailableFlights")
	public ResponseEntity<List<Flight>> getAvailableFlights(@RequestParam String source, @RequestParam String destination, @RequestParam String date){
		List<Flight> flights = null;
		try {
			flights = adminService.getAvailableFlights(date, source, destination);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Flight>>(flights,HttpStatus.OK); 
	}

	
}
