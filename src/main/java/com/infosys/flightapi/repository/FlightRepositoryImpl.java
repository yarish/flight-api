package com.infosys.flightapi.repository;

import com.infosys.flightapi.model.Flight;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FlightRepositoryImpl implements FlightRepository{
    private static final List<Flight> flights = new ArrayList<>();

    static {
        flights.add(new Flight("A101", "AMS", "DEL", "11:00", "17:00", 850));
        flights.add(new Flight("B101", "AMS", "BOM", "12:00", "19:30", 750));
        flights.add(new Flight("C101", "AMS", "BLR", "13:00", "18:30", 800));
        flights.add(new Flight("D101", "AMS", "MAA", "09:00", "15:00", 600));
        flights.add(new Flight("E101", "MAA", "BOM", "16:00", "17:30", 100));
        flights.add(new Flight("F101", "BOM", "DEL", "20:30", "21:30", 80));
        flights.add(new Flight("G101", "BOM", "DEL", "18:00", "19:30", 100));
        flights.add(new Flight("A201", "LHR", "DEL", "11:30", "17:00", 600));
        flights.add(new Flight("B201", "LHR", "BOM", "12:35", "19:30", 750));
        flights.add(new Flight("C201", "LHR", "BLR", "13:45", "18:30", 800));
        flights.add(new Flight("D201", "LHR", "MAA", "09:00", "15:00", 600));
        flights.add(new Flight("E201", "DEL", "BOM", "18:45", "20:15", 100));
        flights.add(new Flight("F201", "BOM", "DEL", "21:15", "22:30", 80));
        flights.add(new Flight("G01", "BOM", "DEL", "20:20", "21:30", 100));
    }

    @Override
    public List<Flight> findByOriginAndDestination(String origin, String destination) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getOrigin().equals(origin) && flight.getDestination().equals(destination)) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }
}
