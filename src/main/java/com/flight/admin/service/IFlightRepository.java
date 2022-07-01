package com.flight.admin.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flight.admin.entity.Flight;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, Integer>{
	
	@Transactional
	@Modifying
	@Query("update Flight f set f.status = false where f.airline = :airline")
	void blockAirline(@Param("airline") String airline);
	
	@Query("select f from Flight f where f.source = :source AND f.destination = :destination AND f.days LIKE %:day% AND f.status = true")
	List<Flight> getAvailableFlights(@Param("day") String day,@Param("source") String source,@Param("destination") String destination);
	
//	select f from Flight f where f.source = :source AND f.destination = :destination AND f.days LIKE %:day% AND f.status = true
			
	

}
