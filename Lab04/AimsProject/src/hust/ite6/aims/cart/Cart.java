package hust.ite6.aims.cart;

import hust.ite6.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
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


//    public void print() {
//        System.out.println("***********************CART***********************");
//        System.out.println("Ordered Items:");
//        for (int i = 0; i < qtyOrdered; i++) {
//            System.out.println(itemsOrdered[i].toString());
//        }
//        System.out.println("Total cost: " + totalCost());
//        System.out.println("***************************************************");
//    }

//    public void searchDigitalVideoDisc(int id) {
//        boolean found = false;
//        for (int i = 0; i < qtyOrdered; i++) {
//            if (itemsOrdered[i].getId() == id) {
//                System.out.println("Found: " + itemsOrdered[i].toString());
//                found = true;
//            }
//        }
//        if (!found) {
//            System.out.println("No match found for the id: " + id);
//        }
//    }

//    public void searchDigitalVideoDisc(String title) {
//        boolean found = false;
//        String[] keywords = title.toLowerCase().split(" ");
//        Set<Integer> Ids = new HashSet<>();
//        for (int i = 0; i < qtyOrdered; i++) {
//            for (String keyword : keywords) {
//                if (itemsOrdered[i].getTitle().toLowerCase().contains(keyword)) {
//                    Ids.add(i);
//                    found = true;
//                }
//            }
//        }
//        if (!found) {
//            System.out.println("No match found for the title: " + title);
//        }
//        else {
//            for (Integer id : Ids) {
//                System.out.println("Found: " + itemsOrdered[id].toString());
//            }
//        }
//    }
}
