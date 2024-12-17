package hust.ite6.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }


    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        authors.remove(authorName);
        // the remove method automatically checks for existence
    }

    @Override
    public String toString() {
        return getId() + ". Book - " + getTitle() + " - " + getCategory() + " - " + authors + ": " + getCost() + " $";
    }
}
