package com.makemytrip.makemytrip.controllers;

import com.makemytrip.makemytrip.models.Flight;
import com.makemytrip.makemytrip.repositories.FlightRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
@CrossOrigin(origins = "http://localhost:3000")
public class FlightController {

    private final FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    // ADD FLIGHT
    @PostMapping("/add")
    public Flight addFlight(@RequestBody Flight flight) {
        return flightRepository.save(flight);
    }

    // UPDATE FLIGHT
    @PutMapping("/update/{id}")
    public Flight updateFlight(@PathVariable String id, @RequestBody Flight flight) {
        flight.setId(id);
        return flightRepository.save(flight);
    }

    // GET ALL FLIGHTS
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // DELETE FLIGHT
    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable String id) {
        flightRepository.deleteById(id);
    }
}