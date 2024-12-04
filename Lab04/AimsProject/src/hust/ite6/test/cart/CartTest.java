package hust.ite6.test.cart;

import hust.ite6.aims.cart.Cart;
import hust.ite6.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion king", "Animation", "Roger Allers", 87, 19.95f);
//        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sciene Fiction", "George Lucas", 87, 24.85f);
//        cart.addDigitalVideoDisc(dvd2);

//        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation",  18.99f);
//        cart.addDigitalVideoDisc(dvd3);

//        cart.searchDigitalVideoDisc(2);
//        cart.print();
//        cart.searchDigitalVideoDisc("star wars lion foo bar");
    }
}
