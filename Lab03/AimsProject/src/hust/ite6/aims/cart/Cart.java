package hust.ite6.aims.cart;

import hust.ite6.aims.disc.DigitalVideoDisc;

import java.util.HashSet;
import java.util.Set;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;

    public Cart() {
        qtyOrdered = 0;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc " + disc.getTitle() + " has been added. Dang Phuong Nam 20225892");
        }
        else {
            System.out.println("Can not add the disc. The cart is full. Dang Phuong Nam 20225892");
        }
    }

//    public void addDigitalVideoDisc(hust.ite6.aims.disc.DigitalVideoDisc[] dvdList) {
//        int i = 0;
//        while (qtyOrdered < MAX_NUMBERS_ORDERED && i < dvdList.length) {
//            itemsOrdered[qtyOrdered] = dvdList[i];
//            System.out.println("The disc " + dvdList[i].getTitle() + " has been added. Dang Phuong Nam 20225892");
//            qtyOrdered++;
//            i++;
//        }
//        if (i == dvdList.length) {
//            System.out.println("All discs have been added. Dang Phuong Nam 20225892");
//        }
//        else {
//            System.out.println("Can not add all discs. The cart is full. Dang Phuong Nam 20225892");
//        }
//    }

    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        int i = 0;
        while (qtyOrdered < MAX_NUMBERS_ORDERED && i < dvdList.length) {
            itemsOrdered[qtyOrdered] = dvdList[i];
            System.out.println("The disc " + dvdList[i].getTitle() + " has been added. Dang Phuong Nam 20225892");
            qtyOrdered++;
            i++;
        }
        if (i == dvdList.length) {
            System.out.println("All discs have been added. Dang Phuong Nam 20225892");
        }
        else {
            System.out.println("Can not add all discs. The cart is full. Dang Phuong Nam 20225892");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j+1];
                }
            }
        }
        qtyOrdered--;
        System.out.println("The disc has been removed. Dang Phuong Nam 20225892");
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }


    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public void searchDigitalVideoDisc(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for the id: " + id);
        }
    }

    public void searchDigitalVideoDisc(String title) {
        boolean found = false;
        String[] keywords = title.toLowerCase().split(" ");
        Set<Integer> Ids = new HashSet<>();
        for (int i = 0; i < qtyOrdered; i++) {
            for (String keyword : keywords) {
                if (itemsOrdered[i].getTitle().toLowerCase().contains(keyword)) {
                    Ids.add(i);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No match found for the title: " + title);
        }
        else {
            for (Integer id : Ids) {
                System.out.println("Found: " + itemsOrdered[id].toString());
            }
        }
    }
}
