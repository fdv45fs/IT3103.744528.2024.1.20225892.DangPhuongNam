package hust.ite6.test.store;

import hust.ite6.aims.media.DigitalVideoDisc;
import hust.ite6.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Roger Allers", 87, 18.99f);

        System.out.println("Adding DVDs:");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        System.out.println("Removing a DVD from the store:");
        store.removeMedia(dvd2);
    }
}