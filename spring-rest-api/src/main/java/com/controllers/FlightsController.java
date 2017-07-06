package com.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Flight;
import com.service.MyService;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class FlightsController {

    @Autowired
    MyService myService;

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightsController.class);

//    @ApiOperation(value = "Returns a list with all the Corporation Administrators.",tags = "05.Corporations")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
//                    required = true, dataType = "string", paramType = "header")
//    })
    @Description("get all corporation users")
    @RequestMapping(value = "/flights", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Iterable<Flight> readFlights() {
        return myService.readFlights();
    }

    @RequestMapping(value = "/flights/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public Flight readFlight(@PathVariable long id) {
        return myService.readFlight(id);
    }

    @RequestMapping(value = "/flights", method = RequestMethod.POST, consumes = "application/json", produces = {"application/json", "application/xml"})
    public ResponseEntity createFlight(@RequestBody Flight flight) {
        myService.createFlight(flight);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/flights/{id}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
    public ResponseEntity deleteFlight(@PathVariable long id) {
        myService.readFlight(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/flights", method = RequestMethod.PUT, consumes = "application/json", produces = {"application/json", "application/xml"})
    public ResponseEntity updateFlight(@RequestBody Flight flight) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
