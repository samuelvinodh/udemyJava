package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorImpl {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Albert Caimus","title1",223));
        bookList.add(new Book("Heighder","Being and time",897));
        bookList.add(new Book("Michio Kaku","Quantum Physics",38));
        bookList.add(new Book("Bianca","WWE",34));
        //Collections.sort(bookList, new BookComparator());
        Collections.sort(bookList, new BookComparator().reversed());
        for(Book b: bookList){
            System.out.println(b);
        }
    }
}
