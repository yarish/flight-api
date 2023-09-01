package com.infosys.flightapi.service;

import com.infosys.flightapi.model.Flight;
import com.infosys.flightapi.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FlightServiceImplTest {

    @InjectMocks
    private FlightServiceImpl flightService;

    @Mock
    private FlightRepository flightRepository;

    @Test
    public void testSearchFlights() {
        // Given
        String origin = "BOM";
        String destination = "DEL";

        Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination(destination);

        List<Flight> expectedFlights = Arrays.asList(flight);

        Sort sort = Sort.by(Sort.Order.asc("departureTime"));
        Pageable pageable = PageRequest.of(0, 10, sort);

        // When
        Mockito.when(flightRepository.findByOriginAndDestination(origin, destination, pageable)).thenReturn(expectedFlights);

        List<Flight> actualFlights = flightService.searchFlights(origin, destination, pageable);

        // Then
        assertEquals(expectedFlights, actualFlights);
    }
}
