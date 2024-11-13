package com.dao;

import java.sql.*;

import com.model.Payment;

public class PaymentDao {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ambulance_booking";
        String username = "root";
        String password = "your_password";
        return DriverManager.getConnection(url, username, password);
    }

    public boolean addPayment(Payment payment) {
        String query = "INSERT INTO Payments (booking_id, amount, payment_time, payment_status) VALUES (?, ?, ?, ?)";
        
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, payment.getBookingId());
            ps.setDouble(2, payment.getAmount());
            ps.setTimestamp(3, new Timestamp(payment.getPaymentTime().getTime()));
            ps.setString(4, payment.getPaymentStatus());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
