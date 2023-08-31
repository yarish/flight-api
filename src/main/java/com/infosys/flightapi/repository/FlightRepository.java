package com.infosys.flightapi.repository;

import com.infosys.flightapi.model.Flight;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
    List<Flight> findByOriginAndDestination(String origin, String destination, Pageable pageable);
}
