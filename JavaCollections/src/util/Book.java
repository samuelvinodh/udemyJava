package util;

public class Book implements Comparable<Book>{
    private String authorName;
    private String title;
    private int noOfPages;

    public Book() {
    }

    public Book(String authorName, String title, int noOfPages) {
        this.authorName = authorName;
        this.title = title;
        this.noOfPages = noOfPages;
    }

    @Override
    public String toString() {
        return this.authorName+" - "+this.title+" - "+this.noOfPages;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    @Override
    public int compareTo(Book o) {
        //return this.authorName.compareTo(o.authorName);
        return Integer.compare(this.noOfPages,o.noOfPages);
    }
}
