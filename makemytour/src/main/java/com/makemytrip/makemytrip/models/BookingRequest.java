package com.makemytrip.makemytrip.models;

public class BookingRequest {

    private String userId;
    private String flightId;
    private String hotelId;
    private int seats;
    private int rooms;
    private double price;

    // GETTERS
    public String getUserId() { return userId; }
    public String getFlightId() { return flightId; }
    public String getHotelId() { return hotelId; }
    public int getSeats() { return seats; }
    public int getRooms() { return rooms; }
    public double getPrice() { return price; }

    // SETTERS
    public void setUserId(String userId) { this.userId = userId; }
    public void setFlightId(String flightId) { this.flightId = flightId; }
    public void setHotelId(String hotelId) { this.hotelId = hotelId; }
    public void setSeats(int seats) { this.seats = seats; }
    public void setRooms(int rooms) { this.rooms = rooms; }
    public void setPrice(double price) { this.price = price; }
}