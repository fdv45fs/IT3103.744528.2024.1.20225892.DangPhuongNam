package hust.ite6.aims.store;

import hust.ite6.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public Store() {

    }

    public void addMedia(Media... mediaList) {
        for (Media media : mediaList) {
            itemsInStore.add(media);
            System.out.println("The Media " + media.getTitle() + " has been added to the store. Dang Phuong Nam 20225892");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media))
            System.out.println("The Media has been removed from the store. Dang Phuong Nam 20225892");
        else
            System.out.println("The Media is not in the store. Dang Phuong Nam 20225892");
    }
}
