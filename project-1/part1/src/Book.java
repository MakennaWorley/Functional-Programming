// This class is already written for you - you don't need to do anything here
public class Book {

    private final String title;
    private final Person author;
    private final int year;

    public Book(String title, Person author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String title() {
        return title;
    }

    public Person author() {
        return author;
    }

    public int year() {
        return year;
    }

    @Override
    public String toString() {
        return "Book[title=" + title + ", author=" + author + ", year=" + year + "]";
    }
}
