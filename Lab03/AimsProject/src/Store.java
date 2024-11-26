public class Store {
    private DigitalVideoDisc[] itemsInStore;

    public Store(int capacity) {
        itemsInStore = new DigitalVideoDisc[capacity];
    }

    public void addDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < itemsInStore.length; i++) {
            if (itemsInStore[i] == null) {
                itemsInStore[i] = dvd;
                System.out.println("The DVD " + dvd.getTitle() + " has been added to the store. Dang Phuong Nam 20225892");
                return;
            }
        }
        System.out.println("The store is full. Dang Phuong Nam 20225892");
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < itemsInStore.length; i++) {
            if (itemsInStore[i] == dvd) {
                itemsInStore[i] = null;
                System.out.println("The DVD " + dvd.getTitle() + " has been removed from the store. Dang Phuong Nam 20225892");
                return;
            }
        }
        System.out.println("The DVD is not in the store. Dang Phuong Nam 20225892");
    }
}
