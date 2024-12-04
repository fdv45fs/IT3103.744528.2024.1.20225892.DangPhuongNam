package hust.ite6.aims.media;

public abstract class Disc extends Media {
    protected int length;
    protected String director;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public Disc(String title, String category, float cost, int length, String director) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }

    @Override
    public abstract String toString();
}
