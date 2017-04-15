package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.configuration.MyConfig;
import com.entities.Flight;
import com.entities.Flights;
import com.entities.Response;
import com.repository.FlightRepository;
import com.repository.FlightRepository1;

@Service
public class MyService {

    @Autowired
    FlightRepository1 flRepo1;

    @Autowired
    MyConfig configuration;

    private static final Logger log = LoggerFactory.getLogger(MyService.class);

    public Flight readFlight(int id) {
        return flRepo1.findOne(Long.valueOf(id));
    }

    public Iterable<Flight> readFlights() {
        return flRepo1.findAll();
    }

    public void createFlight(Flight flight) {
        flRepo1.save(flight);
    }

    public void deleteFlight(int id) {
        flRepo1.delete(Long.valueOf(id));
    }

    public void updateFlight(Flight flight) {
        flRepo1.save(flight);
    }
}
