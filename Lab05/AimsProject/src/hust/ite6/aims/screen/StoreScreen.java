package hust.ite6.aims.screen;

import hust.ite6.aims.cart.Cart;
import hust.ite6.aims.media.*;
import hust.ite6.aims.store.Store;
import javafx.application.Platform;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreScreen  extends JFrame {
    private Store store;
    private Cart cart;
    private CartScreen cartScreen;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookMenuItem = new JMenuItem("Add Book");
        JMenuItem addCDMenuItem = new JMenuItem("Add CD");
        JMenuItem addDVDMenuItem = new JMenuItem("Add DVD");

        addDVDMenuItem.addActionListener(e -> {
            // Open the AddDVD screen when "Add DVD" is clicked
            new AddDigitalVideoDiscToStoreScreen(store, cart, StoreScreen.this);
        });
        addCDMenuItem.addActionListener(e -> {
            // Open the AddDVD screen when "Add DVD" is clicked
            new AddCompactDiscToStoreScreen(store, cart, StoreScreen.this);
        });
        addBookMenuItem.addActionListener(e -> {
            // Open the AddDVD screen when "Add DVD" is clicked
            new AddBookToStoreScreen(store, cart, StoreScreen.this);
        });

        smUpdateStore.add(addBookMenuItem);
        smUpdateStore.add(addCDMenuItem);
        smUpdateStore.add(addDVDMenuItem);

        JMenuItem viewStoreMenuItem = new JMenuItem("View Store");

        JMenuItem viewCartMenuItem = new JMenuItem("View Cart");
        viewCartMenuItem.addActionListener(e -> {
            // Create and display the CartScreen
            Platform.runLater(() -> {
                if (cartScreen == null) {
                    cartScreen = new CartScreen(cart);
                }
                cartScreen.setVisible(true);
            });
        });
        menu.add(smUpdateStore);
        menu.add(viewStoreMenuItem);
        menu.add(viewCartMenuItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS Nam 20225892");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cartButton = new JButton("View cart");
        cartButton.setPreferredSize(new Dimension(100, 50));
        cartButton.setMaximumSize(new Dimension(100, 50));

        cartButton.addActionListener(e -> {
            // Create and display the CartScreen
            Platform.runLater(() -> {
                if (cartScreen == null) {
                    cartScreen = new CartScreen(cart);
                }
                cartScreen.setVisible(true);
            });
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (Media media : mediaInStore) {
            MediaStore cell = new MediaStore(media, cart);
            center.add(cell);
        }

        return center;
    }

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public void updateStoreScreen() {
        getContentPane().remove(1);
        getContentPane().add(createCenter(), BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}