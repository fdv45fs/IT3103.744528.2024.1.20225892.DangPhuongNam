package hust.ite6.aims;

import hust.ite6.aims.cart.Cart;
import hust.ite6.aims.media.*;
import hust.ite6.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static final Store store = new Store();
    private static Cart cart = new Cart();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu(boolean isPlayable) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        if (isPlayable)
            System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void viewStore() {
        store.print();
        int option;
        do {
            storeMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCartFromStore();
                    break;
                case 3:
                    playMediaInStore();
                    break;
                case 4:
                    seeCurrentCart(); // Call the existing cart menu function
                    break;
                case 0:
                    break; // Back to main menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);
    }

    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media[] foundList = store.searchMedia(title);
        if (foundList.length > 0 ) {
            Media found = foundList[0];
            boolean isPlayable = found instanceof Playable;

            int option;
            do {
                System.out.println(found);
                mediaDetailsMenu(isPlayable);
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        cart.addMedia(found);
                        System.out.println("Cart contains " + cart.getSizeItemsOrdered() + " item(s).");
                        break;
                    case 2:
                        if (isPlayable) {
                            ((Playable) found).play();
                        } else {
                            System.out.println("This media is not playable.");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (option != 0);
        }
        else {
            System.out.println("The media with the title '" + title + "' does not exist.");
        }
    }

    public static void addMediaToCartFromStore() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media[] foundList = store.searchMedia(title);
        if (foundList.length > 0) {
            cart.addMedia(foundList[0]);
            System.out.println("Cart contains " + cart.getSizeItemsOrdered() + " item(s).");
        } else {
            System.out.println("The media with the title '" + title + "' does not exist.");
        }
    }

    public static void playMediaInStore() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media[] foundList = store.searchMedia(title);
        if (foundList.length > 0) {
            Media found = foundList[0];
            boolean isPlayable = found instanceof Playable;
            if (isPlayable) {
                ((Playable) found).play();
            } else {
                System.out.println("This media is not playable.");
            }
        }
        else{
            System.out.println("The media with the title '" + title + "' does not exist.");
        }
    }

    public static void seeCurrentCart() {
        int option;
        do {
            cartMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    filterMediasInCart();
                    break;
                case 2:
                    sortMediasInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaInCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    break; // Back to main menu or store menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);
    }

    public static void filterMediasInCart() {
        int option;
        do {
            System.out.println("1. Filter by ID");
            System.out.println("2. Filter by title");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    filterMediaById();
                    break;
                case 2:
                    filterMediaByTitle();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);
    }

    public static void filterMediaById() {
        System.out.print("Enter the ID of the media: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Media found = cart.searchMedia(id);
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("No match found for the ID: " + id);
        }
    }

    public static void filterMediaByTitle() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media[] foundList = cart.searchMedia(title);
        if (foundList.length > 0) {
            for (Media media : foundList) {
                System.out.println(media);
            }
        } else {
            System.out.println("No match found for the title: " + title);
        }
    }

    public static void sortMediasInCart() {
        int option;
        do {
            System.out.println("1. Sort by title");
            System.out.println("2. Sort by cost");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    cart.sortMedia(Media.COMPARE_BY_TITLE_COST);
                    System.out.println("Sorted by title.");
                    break;
                case 2:
                    cart.sortMedia(Media.COMPARE_BY_COST_TITLE);
                    System.out.println("Sorted by cost.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);
    }

    public static void removeMediaFromCart() {
        cart.print();
        System.out.print("Enter the ID of the media to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Media found = cart.searchMedia(id);
        cart.removeMedia(found); // Null safe
    }

    public static void playMediaInCart() {
        cart.print();
        System.out.print("Enter the ID of the media to play: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Media found = cart.searchMedia(id);
        if (found instanceof Playable) {
            ((Playable) found).play();
        }  else if (found == null) {
            System.out.println("Media not found in cart.");
        } else {
            System.out.println("This media is not playable.");
        }
    }

    public static void placeOrder() {
        System.out.println("An order is created.");
        cart = new Cart(); // Reset the cart after placing the order
    }

    public static void updateStore() {
        int option;
        do {
            System.out.println("1. Add media to store");
            System.out.println("2. Remove media from store");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1: //add media
                    System.out.print("Type (1:CD, 2:DVD, 3:Book): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Cost: ");
                    float cost = scanner.nextFloat();
                    scanner.nextLine();

                    String director;
                    int length;
                    switch (type) {
                        case 1:
                            System.out.print("Director: ");
                            director = scanner.nextLine();
                            System.out.print("Artist: ");
                            String artist = scanner.nextLine();
                            store.addMedia(new CompactDisc(title, category, cost, director, artist));
                            break;
                        case 2:
                            System.out.print("Director: ");
                            director = scanner.nextLine();
                            System.out.print("Length: ");
                            length = scanner.nextInt();
                            scanner.nextLine();
                            store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
                            break;
                        case 3:
                            store.addMedia(new Book(title, category, cost));
                            break;
                        default:
                            System.out.println("Invalid type. Please try again.");
                    }
                    break;
                case 2: //remove media
                    System.out.print("Enter the title of the media: ");
                    title = scanner.nextLine();
                    Media[] foundList = store.searchMedia(title);
                    if (foundList.length > 0) {
                        Media found = foundList[0];
                        store.removeMedia(found); // Null safe
                    }
                    else {
                        System.out.println("No match found for the title: " + title);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);
    }

}