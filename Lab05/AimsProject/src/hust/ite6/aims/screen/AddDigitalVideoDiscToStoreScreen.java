package hust.ite6.aims.screen;

import hust.ite6.aims.cart.Cart;
import hust.ite6.aims.media.DigitalVideoDisc;
import hust.ite6.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart, StoreScreen parentScreen) {
        super(store, cart, parentScreen);

        setTitle("Add DVD");
        setVisible(true);
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2));

        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfDirector = new JTextField();
        tfLength = new JTextField();
        tfCost = new JTextField();

        center.add(new JLabel("Title:"));
        center.add(tfTitle);
        center.add(new JLabel("Category:"));
        center.add(tfCategory);
        center.add(new JLabel("Director:"));
        center.add(tfDirector);
        center.add(new JLabel("Length:"));
        center.add(tfLength);
        center.add(new JLabel("Cost:"));
        center.add(tfCost);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String director = tfDirector.getText();
                int length = 0;
                try {
                    length = Integer.parseInt(tfLength.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AddDigitalVideoDiscToStoreScreen.this,
                            "Invalid length format!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                float cost = 0f;
                try {
                    cost = Float.parseFloat(tfCost.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AddDigitalVideoDiscToStoreScreen.this,
                            "Invalid cost format!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                store.addMedia(dvd);

                JOptionPane.showMessageDialog(AddDigitalVideoDiscToStoreScreen.this,
                        "DVD added to store!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Clear the text fields
                tfTitle.setText("");
                tfCategory.setText("");
                tfDirector.setText("");
                tfLength.setText("");
                tfCost.setText("");
            }
        });

        center.add(addButton);

        return center;
    }
}
