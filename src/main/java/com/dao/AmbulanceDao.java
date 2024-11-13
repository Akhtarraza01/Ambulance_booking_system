package com.dao;

import java.sql.*;

import com.model.Ambulance;

public class AmbulanceDao {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ambulance_booking";
        String username = "root";
        String password = "your_password";
        return DriverManager.getConnection(url, username, password);
    }

    public Ambulance getAmbulanceById(int ambulanceId) {
        Ambulance ambulance = null;
        String query = "SELECT * FROM Ambulances WHERE ambulance_id = ?";
        
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, ambulanceId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ambulance = new Ambulance();
                ambulance.setAmbulanceId(rs.getInt("ambulance_id"));
                ambulance.setAmbulanceType(rs.getString("ambulance_type"));
                ambulance.setDriverId(rs.getInt("driver_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ambulance;
    }
}
