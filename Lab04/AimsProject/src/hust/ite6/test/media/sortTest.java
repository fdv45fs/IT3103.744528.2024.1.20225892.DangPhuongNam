package hust.ite6.test.media;

import hust.ite6.aims.media.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class sortTest {
    public static void main(String[] args) {
        List<Media> medias = new ArrayList<Media>();

        CompactDisc cd = new CompactDisc("TieuDeCD", "TheLoaiCD", 15.2f, "DaoDienCD", "NgheSiCD");
        cd.addTrack(new Track("TieuDeTrack1", 3));
        cd.addTrack(new Track("TieuDeTrack2", 5));
        medias.add(cd);

        DigitalVideoDisc dvd = new DigitalVideoDisc("TieuDeDVD", "TheLoaiDVD", "DaoDienDVD", 46, 4.2f);
        medias.add(dvd);

        Book book = new Book("TieuDeBook", "TheLoaiBook", 2.9f);
        book.addAuthor("TacGia1");
        book.addAuthor("TacGia2");
        medias.add(book);

        medias.sort(Media.COMPARE_BY_TITLE_COST);
        for (Media m: medias) {
            System.out.println(m.toString());
        }
        System.out.println("Next sort:");
        medias.sort(Media.COMPARE_BY_COST_TITLE);
        for (Media m: medias) {
            System.out.println(m.toString());
        }
    }
}
