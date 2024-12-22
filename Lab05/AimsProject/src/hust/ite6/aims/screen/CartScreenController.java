package hust.ite6.aims.screen;

import hust.ite6.aims.cart.Cart;
import hust.ite6.aims.media.Media;
import hust.ite6.aims.media.Playable;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;

public class CartScreenController {
    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button placeOrderButton;

    @FXML
    private Label totalCostLabel;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        System.out.println("CartScreenController.initialize() called"); // Add log
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
        updateTotalCost();
        cart.getItemsOrdered().addListener((javafx.collections.ListChangeListener<Media>) change -> {
            while (change.next()) {
                updateTotalCost();
            }
        });

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                });

    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        updateTotalCost();
    }

    @FXML
    void handlePlayMedia(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            Playable playable = (Playable) media;
            try {
                // Play the media
                playable.play();

                // Display a dialog with the media content (replace with actual playback logic)
                Platform.runLater(() -> {
                    JDialog playDialog = new JDialog();
                    playDialog.setTitle("Playing: " + media.getTitle());
                    playDialog.setSize(400, 300);
//                    JTextArea textArea = new JTextArea(message);
//                    textArea.setEditable(false);
//                    playDialog.add(new JScrollPane(textArea));
                    playDialog.setVisible(true);
                });

            } catch (Exception ex) {
                // Handle any exceptions during playback
                Platform.runLater(() -> {
                    JOptionPane.showMessageDialog(null,
                            "Error playing media: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                });
            }
        }
    }

    @FXML
    void handlePlaceOrder(ActionEvent event) {
        cart.clear();

        // Refresh the table view
        //tblMedia.setItems(cart.getItemsOrdered());

        // Update the total cost label
        updateTotalCost();

        JOptionPane.showMessageDialog(null,
                "Order placed successfully! Cart has been cleared.",
                "Order Placed",
                JOptionPane.INFORMATION_MESSAGE);
    }

    void updateTotalCost() {
        // Update the total cost label in the JavaFX thread
        Platform.runLater(() -> {
            String totalCost = String.format("%.2f $", cart.totalCost());
            totalCostLabel.setText(totalCost);
        });
    }
}
