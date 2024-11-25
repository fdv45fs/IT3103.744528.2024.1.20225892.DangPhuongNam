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

//    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
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

}
