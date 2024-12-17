package hust.ite6.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director);
    }

    @Override // overriding the toString() method of java.lang.Object
    public String toString() {
        return getId() + ". DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + ": " + getCost() + " $";
    }

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

}
