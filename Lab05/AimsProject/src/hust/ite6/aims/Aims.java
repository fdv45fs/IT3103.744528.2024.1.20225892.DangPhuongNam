package hust.ite6.aims;

import hust.ite6.aims.cart.Cart;
import hust.ite6.aims.media.Book;
import hust.ite6.aims.media.CompactDisc;
import hust.ite6.aims.media.DigitalVideoDisc;
import hust.ite6.aims.screen.StoreScreen;
import hust.ite6.aims.store.Store;

import javax.swing.*;

public class Aims {
    public static void main(String[] args) {
        new javafx.embed.swing.JFXPanel();
        Store store = new Store();
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        CompactDisc cd1 = new CompactDisc("Star Wars", "Science Fiction",  87f, "George Lucas", "George Lucas");
        Book book1 = new Book("Aladin", "Fairy Tales", 19.95f);

        store.addMedia(dvd1);
        store.addMedia(cd1);
        store.addMedia(book1);
        SwingUtilities.invokeLater(() -> {
            StoreScreen storeScreen = new StoreScreen(store, cart);
            storeScreen.setVisible(true);
            storeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}