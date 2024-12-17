package hust.ite6.aims.store;

import hust.ite6.aims.media.Media;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Store {
    private final ArrayList<Media> itemsInStore = new ArrayList<>();

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

    public Media searchMedia(int id) {
        for (Media media : itemsInStore) {
            if (media.getId() == id) {
                //System.out.println("Found: " + media.toString());
                return media;
            }
        }
        //System.out.println("No match found for the id: " + id);
        return null;
    }

    public Media[] searchMedia(String title) {
        String[] keywords = title.toLowerCase().split(" ");
        Set<Media> retMedia = new HashSet<>();
        for (Media media : itemsInStore) {
            for (String keyword : keywords) {
                if (media.getTitle().toLowerCase().contains(keyword)) {
                    retMedia.add(media);
                }
            }
        }
        return retMedia.toArray(new Media[0]);
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items:");
        for (Media m : itemsInStore) {
            System.out.println(m);
        }
        System.out.println("***************************************************");
    }
}
