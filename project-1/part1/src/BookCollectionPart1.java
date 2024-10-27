import java.util.*;

public class BookCollectionPart1 {

    public static List<Book> getCollection() {
        // Fill in with your code!
        // At least 10 books with at least 3 authors

        Person RR = new Person("Rick Riordan", 1964);
        Person BM = new Person("Brandon Mull", 1974);
        Person CS = new Person("C.S. Lewis", 1898);

        Book LT = new Book("Percy Jackson & the Olympians: The Lighting Thief", RR, 2005);
        Book SM = new Book("Percy Jackson & the Olympians: The Sea of Monsters", RR, 2006);
        Book TC = new Book("Percy Jackson & the Olympians: The Titan's Curse", RR, 2007);
        Book BL = new Book("Percy Jackson & the Olympians: The Battle of the Labyrinth", RR, 2008);
        Book LO = new Book("Percy Jackson & the Olympians: The Last Olympian", RR, 2009);

        Book F = new Book("Fablehaven", BM, 2006);
        Book FRES = new Book("Fablehaven: Rise of the Evening Star", BM, 2007);
        Book FGSP = new Book("Fablehaven: Grip of the Shadow Plague", BM, 2008);
        Book FSDS = new Book("Fablehaven: Secrets of the Dragon Sanctuary", BM, 2009);
        Book FKDP = new Book("Fablehaven: Keys to the Demon Prison", BM, 2010);

        Book LWW = new Book("The Lion, the Witch and the Wardrobe", CS, 1950);
        Book PC = new Book("Prince Caspian: The Return to Narnia", CS, 1951);
        Book VD = new Book("The Voyage of the Dawn Treader", CS, 1952);

        return List.of(LT, SM, TC, BL, LO, F, FRES, FGSP, FSDS, FKDP, LWW, PC, VD); // replace with your own code
    }

    public static void main(String[] args) {
        List<Book> collection = getCollection();
        Scanner in = new Scanner(System.in);

        // Write code to, in a loop, have the user enter a keyword, then print out all books
        // whose title contains the keyword. (Print the book year, title, and author name.)
        // Exit when the user types in a blank.

        // Your code to print out all the books should be written in a functional style, using
        // streams (collection.stream()....) - no loops!
        //   - .filter() to get only books containing the keyword
        //   - .map() to turn the book (and author) into an appropriate string
        //   - .forEach() to print them out

        while (true) {
            System.out.print("Enter a keyword to search the list, leave blank if you want to exit: ");
            String keyword = in.nextLine();
            if (keyword.isBlank()) {
                break;
            }

            collection.stream()
                    .filter(book -> (book.title().toLowerCase()).contains(keyword.toLowerCase()))
                    .map(book -> book.year() + " " + book.title() + " " + book.author().name())
                    .forEach(System.out::println);
        }

        in.close();
    }
}
