package CONTROLLER;

import DAO.DeliveryDAO;
import MODEL.Delivery;

import java.sql.SQLException;
import java.util.List;

public class DeliveryController {
    private DeliveryDAO deliveryDAO;

    public DeliveryController() {
        this.deliveryDAO = new DeliveryDAO();
    }

    public List<Delivery> getAllDeliveries() {
        try {
            return deliveryDAO.getAllDeliveries();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addDelivery(Delivery delivery) {
        try {
            deliveryDAO.addDelivery(delivery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}