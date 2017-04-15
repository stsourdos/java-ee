package com.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.entities.Flight;

public interface FlightRepository1 extends PagingAndSortingRepository<Flight, Long> {

}
