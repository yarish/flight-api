package com.infosys.flightapi.controller;

import com.infosys.flightapi.model.Flight;
import com.infosys.flightapi.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightSearchController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(@RequestParam String origin, @RequestParam String destination) {
        List<Flight> flights = flightService.searchFlights(origin, destination);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
}
