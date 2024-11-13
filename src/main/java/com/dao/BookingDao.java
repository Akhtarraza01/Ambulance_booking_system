package com.dao;

import java.sql.*;

import com.model.Booking;

public class BookingDao {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ambulance_booking";
        String username = "root";
        String password = "your_password";
        return DriverManager.getConnection(url, username, password);
    }

    public boolean addBooking(Booking booking) {
        String query = "INSERT INTO Bookings (user_id, ambulance_id, booking_time, pickup_location, drop_location, status) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, booking.getUserId());
            ps.setInt(2, booking.getAmbulanceId());
            ps.setTimestamp(3, new Timestamp(booking.getBookingTime().getTime()));
            ps.setString(4, booking.getPickupLocation());
            ps.setString(5, booking.getDropLocation());
            ps.setString(6, booking.getStatus());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
