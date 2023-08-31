package com.infosys.flightapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "flights")
public class Flight {
    @Id
    @Column(name = "flight_number")
    private String flightNumber;
    @Column(name = "origin")
    private String origin;
    @Column(name = "destination")
    private String destination;
    @Column(name = "departure_time")
    private Time departureTime;
    @Column(name = "arrival_time")
    private Time arrivalTime;
    @Column(name = "price")
    private BigDecimal price;
}
