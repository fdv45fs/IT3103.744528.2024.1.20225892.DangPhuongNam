package hust.ite6.aims.screen;

import hust.ite6.aims.cart.Cart;
import hust.ite6.aims.exception.PlayerException;
import hust.ite6.aims.media.Media;
import hust.ite6.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel{
    //private Media media;
    //private Cart cart;
    public MediaStore(Media media, Cart cart) {
        //this.cart = cart;
        //this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart.addMedia(media);
                JOptionPane.showMessageDialog(MediaStore.this,
                        "Added " + media.getTitle() + " to cart.",
                        "Add to Cart",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        container.add(addToCartButton);
        if(media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Playable playable = (Playable) media;
                    try {
                        // Play the media
                        playable.play();

                        // Display a dialog with the media content (replace with actual playback logic)
//                        JDialog playDialog = new JDialog();
//                        playDialog.setTitle("Playing: " + media.getTitle());
//                        playDialog.setSize(400, 300); // Set a reasonable size
//                        JTextArea textArea = new JTextArea("Playing content..."); // Assuming play() returns String
//                        textArea.setEditable(false);
//                        playDialog.add(new JScrollPane(textArea)); // Add a scroll pane for longer content
//                        playDialog.setVisible(true);
                    } catch (PlayerException ex) {
                        // Handle any exceptions during playback
                        JOptionPane.showMessageDialog(MediaStore.this,
                                "Error playing media: " + ex.getMessage(),
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
