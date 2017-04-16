package com.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.entities.Flight;

public interface FlightRepository extends PagingAndSortingRepository<Flight, Long> {

}
