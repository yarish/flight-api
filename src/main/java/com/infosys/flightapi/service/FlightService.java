package com.infosys.flightapi.service;

import com.infosys.flightapi.model.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> searchFlights(String origin, String destination);
}
