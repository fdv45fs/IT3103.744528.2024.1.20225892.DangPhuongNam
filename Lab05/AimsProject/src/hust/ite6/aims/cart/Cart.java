package hust.ite6.aims.cart;

import hust.ite6.aims.media.Media;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public Cart() {

    }

    public void addMedia(Media... mediaList) {
        for (Media media : mediaList) {
            itemsOrdered.add(media);
            System.out.println("The media " + media.getTitle() + " has been added. Dang Phuong Nam 20225892");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media))
            System.out.println("The media has been removed. Dang Phuong Nam 20225892");
        else
            System.out.println("The media is not in the cart. Dang Phuong Nam 20225892");
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public int getSizeItemsOrdered() {
        return itemsOrdered.size();
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media m : itemsOrdered) {
            System.out.println(m);
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public Media searchMedia(int id) {
        for (Media media : itemsOrdered) {
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
        for (Media media : itemsOrdered) {
            for (String keyword : keywords) {
                if (media.getTitle().toLowerCase().contains(keyword)) {
                    retMedia.add(media);
                }
            }
        }
        return retMedia.toArray(new Media[0]);
    }

    public void sortMedia(Comparator<Media> cmp) {
        itemsOrdered.sort(cmp);
    }
}
