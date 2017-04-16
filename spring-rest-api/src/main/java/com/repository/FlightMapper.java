package com.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.entities.Flight;
import com.utils.MyUtils;

final class FlightMapper implements RowMapper<Flight> {

    private final Logger log = LoggerFactory.getLogger(FlightMapper.class);

    public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
        log.warn("++++++" + Integer.toString(rowNum));
        Flight flight = new Flight();
        flight.setId(rs.getInt("id"));
        flight.setDeparture(rs.getString("departure"));
        flight.setDestination(rs.getString("destination"));
        flight.setDate(MyUtils.stringToDateFormat(rs.getString("date")));
        return flight;
    }
}
