package com.makemytrip.makemytrip.services;

import com.makemytrip.makemytrip.models.Users;
import com.makemytrip.makemytrip.models.Flight;
import com.makemytrip.makemytrip.models.Hotel;
import com.makemytrip.makemytrip.repositories.UserRepository;
import com.makemytrip.makemytrip.repositories.FlightRepository;
import com.makemytrip.makemytrip.repositories.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class BookingService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private HotelRepository hotelRepository;

    // ✈️ BOOK FLIGHT
    public Users.Booking bookFlight(String userId, String flightId, int seats, double price) {

        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        if (flight.getAvailableSeats() < seats) {
            throw new RuntimeException("Not enough seats available");
        }

        flight.setAvailableSeats(flight.getAvailableSeats() - seats);
        flightRepository.save(flight);

        Users.Booking booking = new Users.Booking();
        booking.setType("Flight");
        booking.setBookingId(flightId);
        booking.setDate(LocalDate.now().toString());
        booking.setQuantity(seats);
        booking.setTotalPrice(price);

        if (user.getBookings() == null) {
            user.setBookings(new ArrayList<>());
        }

        user.getBookings().add(booking);
        userRepository.save(user);

        return booking;
    }

    // 🏨 BOOK HOTEL (SEPARATE METHOD ✅)
    public Users.Booking bookHotel(String userId, String hotelId, int rooms, double price) {

        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        if (hotel.getAvailableRooms() < rooms) {
            throw new RuntimeException("Not enough rooms available");
        }

        hotel.setAvailableRooms(hotel.getAvailableRooms() - rooms);
        hotelRepository.save(hotel);

        Users.Booking booking = new Users.Booking();
        booking.setType("Hotel");
        booking.setBookingId(hotelId);
        booking.setDate(LocalDate.now().toString());
        booking.setQuantity(rooms);
        booking.setTotalPrice(price);

        if (user.getBookings() == null) {
            user.setBookings(new ArrayList<>());
        }

        user.getBookings().add(booking);
        userRepository.save(user);

        return booking;
    }
}