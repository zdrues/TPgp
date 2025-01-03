package VIEW;

import CONTROLLER.DeliveryController;
import MODEL.Delivery;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeliveryApp {
    private DeliveryController controller;

    public DeliveryApp() {
        this.controller = new DeliveryController();
        createUI();
    }

    public void createUI() {
        JFrame frame = new JFrame("Gestion des Livraisons");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Tableau pour afficher les livraisons
        String[] columns = { "ID", "Utilisateur", "Adresse", "Statut", "Avis" };
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        // Charger les livraisons
        for (Delivery delivery : controller.getAllDeliveries()) {
            tableModel.addRow(new Object[] {
                    delivery.getId(),
                    delivery.getUserName(),
                    delivery.getDeliveryAddress(),
                    delivery.getStatus(),
                    delivery.getFeedback()
            });
        }

        // ScrollPane pour le tableau
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Formulaire pour ajouter une livraison
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        JTextField userNameField = new JTextField();
        JTextField addressField = new JTextField();
        JComboBox<String> statusBox = new JComboBox<>(new String[] { "Pending", "In Progress", "Completed" });
        JTextField feedbackField = new JTextField();
        JButton addButton = new JButton("Ajouter");

        formPanel.add(new JLabel("Utilisateur :"));
        formPanel.add(userNameField);
        formPanel.add(new JLabel("Adresse :"));
        formPanel.add(addressField);
        formPanel.add(new JLabel("Statut :"));
        formPanel.add(statusBox);
        formPanel.add(new JLabel("Avis :"));
        formPanel.add(feedbackField);
        formPanel.add(addButton);

        frame.add(formPanel, BorderLayout.SOUTH);

        // Action pour le bouton ajouter
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delivery delivery = new Delivery(0, userNameField.getText(), addressField.getText(),
                        statusBox.getSelectedItem().toString(), feedbackField.getText());
                controller.addDelivery(delivery);
                tableModel.addRow(new Object[] {
                        delivery.getId(),
                        delivery.getUserName(),
                        delivery.getDeliveryAddress(),
                        delivery.getStatus(),
                        delivery.getFeedback()
                });
                JOptionPane.showMessageDialog(frame, "Livraison ajoutée !");
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new DeliveryApp();
    }
}