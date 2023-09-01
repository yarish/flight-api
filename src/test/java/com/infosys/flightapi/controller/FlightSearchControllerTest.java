package com.infosys.flightapi.controller;

import com.infosys.flightapi.model.Flight;
import com.infosys.flightapi.service.FlightService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FlightSearchControllerTest {
    @InjectMocks
    private FlightSearchController flightSearchController;

    @Mock
    private FlightService flightService;

    @Test
    void searchFlights() {
        // Given
        String origin = "BOM";
        String destination = "DEL";

        Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setFlightNumber("F201");
        flight.setDepartureTime(Time.valueOf("02:45:00"));
        flight.setArrivalTime(Time.valueOf("04:45:00"));
        flight.setPrice(BigDecimal.valueOf(5000));

        List<Flight> expectedFlights = Arrays.asList(flight);
        Sort sort = Sort.by(Sort.Order.asc("departureTime"));
        Pageable pageable = PageRequest.of(0, 10, sort);

        // When
        Mockito.when(flightService.searchFlights(origin, destination, pageable)).thenReturn(expectedFlights);

        ResponseEntity<List<Flight>> response = flightSearchController.searchFlights(origin, destination, Optional.of(new String[]{"departureTime"}), Optional.of(new String[]{"asc"}), Optional.of(0), Optional.of(10));

        // Then
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedFlights, response.getBody());
    }

    @Test
    public void testBadRequest() {
        // Given
        String origin = "JFK";
        String destination = "SFO";

        // When
        ResponseEntity<List<Flight>> response = flightSearchController.searchFlights(
                origin, destination, Optional.of(new String[]{"departureTime"}),
                Optional.of(new String[]{"asc", "desc"}), Optional.of(0), Optional.of(10)
        );

        // Then
        assertEquals(400, response.getStatusCodeValue());
    }
}