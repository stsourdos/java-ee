package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Flight;
import com.exception.ResourceNotFoundException;
import com.repository.FlightRepository;

@Service
public class MyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyService.class);

    @Autowired
    FlightRepository flightRepo;

    public Flight readFlight(long id) {
        Flight flight = flightRepo.findOne(id);
        if (flight == null) {
            throw new ResourceNotFoundException("Flight Entity was not found");
        }
        return flight;
    }

    public Iterable<Flight> readFlights() {
        return flightRepo.findAll();
    }

    public void createFlight(Flight flight) {
        flightRepo.save(flight);
    }

    public void deleteFlight(long id) {
        readFlight(id);
        flightRepo.delete(id);
    }

    public void updateFlight(Flight flight) {
        readFlight(flight.getId());
        flightRepo.save(flight);
    }
}
