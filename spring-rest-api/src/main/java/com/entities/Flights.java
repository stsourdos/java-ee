package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Flights {

    private List<Flight> flights;
    private int count;

    public List<Flight> getFlights() {
        if (flights == null) {
            flights = new ArrayList<Flight>();
        }

        return flights;
    }

    @XmlElement
    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public int getCount() {
        return count;
    }

    @XmlAttribute
    public void setCount(int count) {
        this.count = count;
    }
}
