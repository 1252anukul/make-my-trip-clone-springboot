package com.makemytrip.makemytrip.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.ArrayList;

@Document(collection = "user")
public class Users {

    @Id
    private String _id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private String phoneNumber;

    // ✅ ADD THIS (VERY IMPORTANT)
    private List<Booking> bookings = new ArrayList<>();


    // ---------------- GETTERS ----------------

    public String getId() {
        return _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public List<Booking> getBookings() {
        return bookings;
    }


    // ---------------- SETTERS ----------------

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    // ✅ INNER CLASS FOR BOOKINGS
    public static class Booking {

        private String type;
        private String bookingId;
        private String date;
        private int quantity;
        private double totalPrice;

        // GETTERS
        public String getType() {
            return type;
        }

        public String getBookingId() {
            return bookingId;
        }

        public String getDate() {
            return date;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        // SETTERS
        public void setType(String type) {
            this.type = type;
        }

        public void setBookingId(String bookingId) {
            this.bookingId = bookingId;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }
    }
}
