package com.infosys.flightapi.repository;

import com.infosys.flightapi.model.Flight;

import java.util.List;

public interface FlightRepository {
    List<Flight> findByOriginAndDestination(String origin, String destination);
}
