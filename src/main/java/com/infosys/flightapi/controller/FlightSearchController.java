package com.infosys.flightapi.controller;

import com.infosys.flightapi.model.Flight;
import com.infosys.flightapi.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
public class FlightSearchController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam Optional<String[]> sortFields,
            @RequestParam Optional<String[]> sortDirections,
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size) {

        List<Order> orders = new ArrayList<>();
        if (sortFields.isPresent() && sortDirections.isPresent()) {
            String[] fields = sortFields.get();
            String[] directions = sortDirections.get();
            if (fields.length != directions.length) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            for (int i = 0; i < fields.length; i++) {
                Sort.Direction direction = Sort.Direction.fromString(directions[i].toUpperCase());
                orders.add(new Order(direction, fields[i]));
            }
        }
        Sort sort = Sort.by(orders);
        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(10), sort);
        List<Flight> flights = flightService.searchFlights(origin, destination, pageable);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
}
