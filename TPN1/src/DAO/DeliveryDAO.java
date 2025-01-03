package DAO;

import MODEL.Delivery;
import DAO.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO {
    public List<Delivery> getAllDeliveries() throws SQLException {
        String query = "SELECT * FROM deliveries";
        List<Delivery> deliveries = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                deliveries.add(new Delivery(
                        rs.getInt("id"),
                        rs.getString("user_name"),
                        rs.getString("delivery_address"),
                        rs.getString("status"),
                        rs.getString("feedback")));
            }
        }
        return deliveries;
    }

    public void addDelivery(Delivery delivery) throws SQLException {
        String query = "INSERT INTO deliveries (user_name, delivery_address, status, feedback) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, delivery.getUserName());
            stmt.setString(2, delivery.getDeliveryAddress());
            stmt.setString(3, delivery.getStatus());
            stmt.setString(4, delivery.getFeedback());
            stmt.executeUpdate();
        }
    }
}