package hust.ite6.aims.media;

import hust.ite6.aims.exception.PlayerException;

import javax.swing.*;
import java.awt.*;

public class DigitalVideoDisc extends Disc implements Playable{

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director);
    }

    @Override // overriding the toString() method of java.lang.Object
    public String toString() {
        return getId() + ". DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + ": " + getCost() + " $";
    }

    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());

            // Instead of printing to console, display in a dialog (GUI)
            JDialog dialog = new JDialog();
            dialog.setTitle("Playing DVD");
            dialog.setSize(300, 200);

            JPanel contentPane = new JPanel();
            contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

            JLabel titleLabel = new JLabel("Playing DVD: " + this.getTitle());
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            contentPane.add(titleLabel);

            JLabel lengthLabel = new JLabel("DVD length: " + this.getLength());
            lengthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            contentPane.add(lengthLabel);

            dialog.add(contentPane);
            dialog.setVisible(true);
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

}
