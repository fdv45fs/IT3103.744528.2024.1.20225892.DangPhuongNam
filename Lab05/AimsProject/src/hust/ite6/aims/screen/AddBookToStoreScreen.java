package hust.ite6.aims.screen;

import hust.ite6.aims.cart.Cart;
import hust.ite6.aims.media.Book;
import hust.ite6.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfAuthors;
    private JTextField tfCost;

    public AddBookToStoreScreen(Store store, Cart cart, StoreScreen parentScreen) {
        super(store, cart, parentScreen);

        setTitle("Add Book");
        setVisible(true);
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(5, 2));

        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfAuthors = new JTextField();
        tfCost = new JTextField();

        center.add(new JLabel("Title:"));
        center.add(tfTitle);
        center.add(new JLabel("Category:"));
        center.add(tfCategory);
        center.add(new JLabel("Authors (comma-separated):"));
        center.add(tfAuthors);
        center.add(new JLabel("Cost:"));
        center.add(tfCost);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String authorsText = tfAuthors.getText();
                float cost = 0f;
                try {
                    cost = Float.parseFloat(tfCost.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AddBookToStoreScreen.this,
                            "Invalid cost format!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Split authors by comma and create a List<String>
                List<String> authors = new ArrayList<>();
                if (!authorsText.isEmpty()) {
                    String[] authorNames = authorsText.split(",");
                    for (String authorName : authorNames) {
                        authors.add(authorName.trim());
                    }
                }

                Book book = new Book(title, category, cost);
                // Add authors to the book
                for (String author : authors) {
                    book.addAuthor(author);
                }
                store.addMedia(book);

                JOptionPane.showMessageDialog(AddBookToStoreScreen.this,
                        "Book added to store!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Clear the text fields
                tfTitle.setText("");
                tfCategory.setText("");
                tfAuthors.setText("");
                tfCost.setText("");
                // Update StoreScreen
                parentScreen.updateStoreScreen();
            }
        });

        center.add(addButton);

        return center;
    }
}