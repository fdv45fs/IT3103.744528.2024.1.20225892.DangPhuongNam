package hust.ite6.aims.screen;

import hust.ite6.aims.cart.Cart;
import hust.ite6.aims.media.CompactDisc;
import hust.ite6.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfArtist;
    private JTextField tfLength;
    private JTextField tfCost;
    private JTextField tfDirector;

    public AddCompactDiscToStoreScreen(Store store, Cart cart, StoreScreen parentScreen) {
        super(store, cart, parentScreen);

        setTitle("Add CD");
        setVisible(true);
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(7, 2));

        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfArtist = new JTextField();
        tfLength = new JTextField();
        tfCost = new JTextField();
        tfDirector = new JTextField();

        center.add(new JLabel("Title:"));
        center.add(tfTitle);
        center.add(new JLabel("Category:"));
        center.add(tfCategory);
        center.add(new JLabel("Artist:"));
        center.add(tfArtist);
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
                String artist = tfArtist.getText();
                String director = tfDirector.getText();
                float cost = 0f;
                try {
                    cost = Float.parseFloat(tfCost.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AddCompactDiscToStoreScreen.this,
                            "Invalid cost format!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                CompactDisc cd = new CompactDisc(title, category, cost, director, artist);
                store.addMedia(cd);

                JOptionPane.showMessageDialog(AddCompactDiscToStoreScreen.this,
                        "CD added to store!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Clear the text fields
                tfTitle.setText("");
                tfCategory.setText("");
                tfArtist.setText("");
                tfLength.setText("");
                tfCost.setText("");
                tfDirector.setText("");
                // Update StoreScreen
                parentScreen.updateStoreScreen();
            }
        });

        center.add(addButton);

        return center;
    }
}