package hust.ite6.aims.media;

public class DigitalVideoDisc extends Disc {
    private String director;
    private int length;
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
    }

    @Override // overriding the toString() method of java.lang.Object
    public String toString() {
        return getId() + ". DVD - " + getTitle() + " - " + getCategory() + " - "
                + director + " - " + length + ": " + getCost() + " $";
    }

}
