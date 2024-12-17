package hust.ite6.aims.media;

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

    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track track) {
            return Objects.equals(this.getTitle(), track.getTitle()) && Objects.equals(this.getLength(), track.getLength());
        }
        else return false;
    }
}
