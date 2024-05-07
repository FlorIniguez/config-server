package com.example.demo.controller;
import com.example.demo.exceptions.ResourcedNotFoundException;
import com.example.demo.model.Flight;
import com.example.demo.model.FlightDto;
import com.example.demo.services.FlightService;
import com.example.demo.utils.FlightUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;
    @Autowired
    FlightUtils flightUtils;

    @CrossOrigin
    @GetMapping("")

    public List<FlightDto>getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public FlightDto findFlightById(@PathVariable Long id) {
            return  flightService.searchFlightById(id);
    }

    @GetMapping("/sale")
    public List<Flight> saleFlights(@RequestParam Integer offerPrice) {
        return flightService.saleFlights(offerPrice);
    }

    @GetMapping("/locations")
    public List<Flight> getFlightsByLocations(@RequestParam String origin, @RequestParam String destiny) {
        return flightService.getByOriginAndDestiny(origin, destiny);
    }

    @GetMapping("/origin")
    public List<Flight> getFlightsByLocations(@RequestParam String origin) {
        return flightService.getByOrigin(origin);
    }

    @PostMapping("/add/{companyId}")
    public Optional<Flight> createFlight(@PathVariable Long companyId, @RequestBody Flight flight) {
        return flightService.createFlight(companyId, flight);
    }

    public Optional<Flight> updateFlight(@RequestBody Flight flight) {
        return flightService.updateFlight(flight);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFlight(@PathVariable Long id) {
        try {
            flightService.deleteFlight(id);
            return "Flight succesfully deleted";
        } catch (ResourcedNotFoundException e) {
            System.out.println(e.getMessage());
            return "Flight not found";
        }
    }

}
