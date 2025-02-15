import java.time.LocalDate
import java.util.Scanner
import scala.collection.SortedMap

import scala.io.Source

/** Returns a LazyList of lines from a ZipEntryReader */
// Your code should call reader.readLine() to get an Option[String] of the next line of the file (None if there are none
// remaining) lazily adding (with #::) the remaining lines of the file.
def zipEntryLines(reader: ZipEntryReader): LazyList[String] =
  reader.readLine() match
    case Some(line) => line #:: zipEntryLines(reader)
    case None => LazyList()


/** Converts a CSV line string to a StockRecord object */
// Use the Pokémon example from class for inspiration. Use LocalDate.parse() to parse the date string.
def lineToStockRecord(line: String): StockRecord =
  val parts = line.split(',')
  StockRecord(java.time.LocalDate.parse(parts(0)), parts(1), parts(2), parts(3).toDouble, parts(4).toDouble, parts(5).toDouble, parts(6).toDouble, parts(7).toDouble, parts(8).toLong)


/** Converts a CSV line string to a Company object */
// Similar to lineToStockRecord(). However, some lines of the CSV don't include a company name, so your code should
// work with both (ticker,name,country) lines and (ticker,name) ones. (Use "" for country if not specified.)
def lineToCompany(line: String): Company =
  val parts = line.split(',')
  if (parts.length == 3) Company(parts(0), parts(1), parts(2))
  else Company(parts(0), parts(1), "")


@main
def nasdaqMain(): Unit =
  // Create ZipEntryReader objects to read nasdaq_2021.csv from data/nasdaq_symbols.zip and
  // "NASDAQ 1962-2024.csv" from data/nasdaq.zip
  // (If you haven't already, download nasdaq.zip and put in the data directory!)
  // Also add .close() calls for both at the bottom of this function!

  val file = new ZipEntryReader("data/nasdaq.zip", "NASDAQ 1962-2024.csv")

  val lines = zipEntryLines(file).drop(1)
  val stocks = lines.map(lineToStockRecord).to(LazyList)

  // Use your zipEntryLines() method to read LazyLists of lines from both files, then .map() them to Company/StockRecord
  // objects using the methods you wrote above

  val file1 = new ZipEntryReader("data/nasdaq_symbols.zip", "nasdaq_2021.csv")

  val lines1 = zipEntryLines(file1).drop(1)
  val companies = lines1.map(lineToCompany).to(LazyList)

  val in = Scanner(System.in)
  while (true) do
    print("Ticker symbol: ")
    val ticker = in.nextLine().toUpperCase

    // Add code:
    //   - Check whether the ticker symbol the user entered is listed in the nasdaq_symbols file, and if it is, print
    //      the name and country of the company (you can either use your LazyList of companies directly or dump them
    //      into a Map first).
    //      (Not all valid ticker symbols are listed in nasdaq_symbols.zip; if this one isn't, then just proceed with
    //      the next step below.)
    //   - In your LazyList of StockRecords, use .dropWhile() and .takeWhile() (see directions) to filter to the
    //      user's entered ticker symbol. Use .groupBy() to group the records by year, then compute the average closing
    //      price and volume for each year. Print out a nice table showing the year, average closing price, and average
    //      volume for each year.
    //      Try to do this without ever writing a loop! All of this is achievable using methods like .map() and .sum().
    //      (SortedMap.from() is a method that takes a Map as parameter and returns a SortedMap - you may find this
    //      helpful!)

    if (ticker.isEmpty) {
      System.exit(0)
    }

    val results = stocks.filter(_.ticker == ticker)

    val resultsYear = SortedMap(results.groupBy(record => record.date.getYear)
      .map { case (year, records) =>
        val avgClose = records.map(_.close).sum / records.size //this is wrong somehow
        val avgVolume = records.map(_.volume).sum / records.size
        (year, (avgClose, avgVolume))
      }.toSeq: _*)

    //resultsYear.foreach(println(_))

    val results1 = companies.filter(_.ticker == ticker)

    results1.foreach { company =>
      println(f"[${company.ticker}] ${company.name} (${company.country}) records:")
    }

    resultsYear.foreach { case (year, (avgClose, avgVolume)) =>
      println(f"$year\t$$${avgClose}%.2f\t\t\t${avgVolume}")
    }


  // Close both the ZipEntryReaders you created at the top
  // companyReader.close()
  // recordReader.close()

  file.close()
  file1.close()