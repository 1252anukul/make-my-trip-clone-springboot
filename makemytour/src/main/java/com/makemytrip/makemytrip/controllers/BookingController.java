package com.makemytrip.makemytrip.controllers;

import com.makemytrip.makemytrip.models.Users;
import com.makemytrip.makemytrip.models.BookingRequest;
import com.makemytrip.makemytrip.services.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // ✈️ BOOK FLIGHT
    @PostMapping("/flight")
    public Users.Booking bookFlight(@RequestBody BookingRequest request) {

        return bookingService.bookFlight(
                request.getUserId(),
                request.getFlightId(),
                request.getSeats(),
                request.getPrice()
        );
    }

    // 🏨 BOOK HOTEL
    @PostMapping("/hotel")
    public Users.Booking bookHotel(@RequestBody BookingRequest request) {

        return bookingService.bookHotel(
                request.getUserId(),
                request.getHotelId(),
                request.getRooms(),
                request.getPrice()
        );
    }
}