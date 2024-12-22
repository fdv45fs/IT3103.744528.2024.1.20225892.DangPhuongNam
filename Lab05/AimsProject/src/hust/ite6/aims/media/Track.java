package hust.ite6.aims.media;

import hust.ite6.aims.exception.PlayerException;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Track implements Playable{
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());

            // Display in a dialog for GUI
            JDialog dialog = new JDialog();
            dialog.setTitle("Playing Track");
            dialog.setSize(300, 200);

            JPanel contentPane = new JPanel();
            contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

            JLabel titleLabel = new JLabel("Playing track: " + this.getTitle());
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            contentPane.add(titleLabel);

            JLabel lengthLabel = new JLabel("Track length: " + this.getLength());
            lengthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            contentPane.add(lengthLabel);

            dialog.add(contentPane);
            dialog.setVisible(true);
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track track) {
            return Objects.equals(this.getTitle(), track.getTitle()) && Objects.equals(this.getLength(), track.getLength());
        }
        else return false;
    }
}
