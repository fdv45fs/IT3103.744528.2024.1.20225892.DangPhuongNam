package hust.ite6.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist, List<Track> tracks) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public void addTrack(Track track) {
        if(tracks.contains(track)) {
            System.out.println("The track is already in the list of tracks. Dang Phuong Nam 20225892");
        } else {
            tracks.add(track);
            System.out.println("The track has been added to the list of tracks. Dang Phuong Nam 20225892");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) { //automatically checks for existence
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
}
