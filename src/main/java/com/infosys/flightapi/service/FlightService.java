package com.infosys.flightapi.service;

import com.infosys.flightapi.model.Flight;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FlightService {
    List<Flight> searchFlights(String origin, String destination, Pageable pageable);
}
