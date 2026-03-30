package com.makemytrip.makemytrip.controllers;

import com.makemytrip.makemytrip.models.Hotel;
import com.makemytrip.makemytrip.repositories.HotelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@CrossOrigin(origins = "http://localhost:3000")
public class HotelController {

    private final HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @PostMapping("/add")
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @PutMapping("/update/{id}")
    public Hotel updateHotel(@PathVariable String id, @RequestBody Hotel hotel) {
        hotel.setId(id);
        return hotelRepository.save(hotel);
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}