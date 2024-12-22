package hust.ite6.aims.media;

import hust.ite6.aims.exception.PlayerException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(String title, String category, float cost, String director, String artist) {
        super(title, category, cost, 0, director);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if(tracks.contains(track)) {
            System.out.println("The track is already in the list of tracks. Dang Phuong Nam 20225892");
        } else {
            tracks.add(track);
            //this.length += track.getLength();
            this.length = this.getLength();
            System.out.println("The track has been added to the list of tracks. Dang Phuong Nam 20225892");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) { //automatically checks for existence
            //this.length -= track.getLength();
            this.length = this.getLength();
            System.out.println("The track has been removed from the list of tracks. Dang Phuong Nam 20225892");
        } else {
            System.out.println("The track is not in the list of tracks. Dang Phuong Nam 20225892");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public void play() throws PlayerException {
//        System.out.println("Playing CD: " + this.getTitle());
//        System.out.println("Artist: " + this.getArtist());
//        for (Track track : tracks) {
//            track.play();
//        }
        if (this.getLength() > 0) {
            // Display CD info in a dialog for GUI
            JDialog dialog = new JDialog();
            dialog.setTitle("Playing CD");
            dialog.setSize(300, 200);

            JPanel contentPane = new JPanel();
            contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

            JLabel titleLabel = new JLabel("Playing CD: " + this.getTitle());
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            contentPane.add(titleLabel);

            JLabel lengthLabel = new JLabel("CD length: " + this.getLength());
            lengthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            contentPane.add(lengthLabel);

            dialog.add(contentPane);

            Iterator<Track> iter = tracks.iterator();
            while (iter.hasNext()) {
                Track nextTrack = iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e) {
                    // Display error in a dialog and rethrow
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Player Error", JOptionPane.ERROR_MESSAGE);
                    throw e;
                }
            }
            dialog.setVisible(true);
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }

    }

    @Override
    public String toString() {
        return getId() + ". CD - " + getTitle() + " - " + getCategory() + " - " + artist + " - " + getLength() + ": " + getCost() + " $";
    }
}
