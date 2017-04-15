package com.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.entities.Flight;

public class MyUtils {

    private static final String format = "yyyy-MM-dd HH:mm:ss";
    private static final Logger log = LoggerFactory.getLogger(MyUtils.class);

    public static Date stringToDateFormat(String str) {
        DateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
        Date date = null;
        log.warn("!!!!!!!!" + str);
        try {
            date = dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static Flight getDummyFlight() {
        Flight flight = new Flight();
        flight.setId(123);
        flight.setDeparture("India");
        flight.setDestination("Thessaloniki");
        flight.setDate(MyUtils.stringToDateFormat("2016-07-12 12:50:00"));
        return flight;
    }
}
