// Scala uses _ instead of * in imports
import java.util._

object BookCollectionPart2 {

  val RR = new Person("Rick Riordan", 1964)
  val BM = new Person("Brandon Mull", 1974)
  val CS = new Person("C.S. Lewis", 1898)

  // Fill this method in with the Scala equivalent of your Java code
  // (write it yourself, don't just paste it from Java - it's good practice!)
  def getCollection(): Array[Book] =
    Array(
      Book("Percy Jackson & the Olympians: The Lighting Thief", RR, 2005),
      Book("Percy Jackson & the Olympians: The Sea of Monsters", RR, 2006),
      Book("Percy Jackson & the Olympians: The Titan's Curse", RR, 2007),
      Book("Percy Jackson & the Olympians: The Battle of the Labyrinth", RR, 2008),
      Book("Percy Jackson & the Olympians: The Last Olympian", RR, 2009),

      Book("Fablehaven", BM, 2006),
      Book("Fablehaven: Rise of the Evening Star", BM, 2007),
      Book("Fablehaven: Grip of the Shadow Plague", BM, 2008),
      Book("Fablehaven: Secrets of the Dragon Sanctuary", BM, 2009),
      Book("Fablehaven: Keys to the Demon Prison", BM, 2010),

      Book("The Lion, the Witch and the Wardrobe", CS, 1950),
      Book("Prince Caspian: The Return to Narnia", CS, 1951),
      Book("The Voyage of the Dawn Treader", CS, 1952),
    ) // replace this with your own code

  def main(args: Array[String]): Unit =
    ()
  // Do the Scala equivalent of the Java code you wrote in part 1:
  // Write code to, in a loop, have the user enter a keyword, then print out all books
  // whose title contains the keyword. (Print the book year, title, and author name.)
  // Exit when the user types in a blank.

  // Use "val" (not "var") whenever possible. You can create a Scanner object in just the same
  // way you do in Java (except that in Scala you don't need to write "new").

  // Your code to print out all the books should be written in a functional style - no loops!
  //   - .filter() to get only books containing the keyword
  //   - .map() to turn the book (and author) into an appropriate string
  //   - .foreach() to print them out

    val in = new Scanner(System.in)

    while (true) {
      System.out.print("Enter a keyword to search the list, leave blank if you want to exit: ")
      val keyword = in.nextLine
      if (keyword.isBlank) System.exit(0)

      getCollection()
          .filter((book: Book) => book.title.toLowerCase.contains(keyword.toLowerCase))
          .map((book: Book) => book.year + " " + book.title + " " + book.author.name)
          .foreach(System.out.println)
    }

    in.close()
}
