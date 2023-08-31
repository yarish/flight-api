package com.infosys.flightapi.service;

import com.infosys.flightapi.model.Flight;
import com.infosys.flightapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> searchFlights(String origin, String destination, Pageable pageable) {
        return flightRepository.findByOriginAndDestination(origin, destination, pageable);
    }
}
