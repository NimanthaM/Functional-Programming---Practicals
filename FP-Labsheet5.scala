//Question 01
import scala.io.StdIn.readLine
import scala.collection.mutable

  def getProductList(): List[String] = {

    def collectProducts(x: List[String]): List[String] = {

      val input = readLine("Enter product name (or type 'done' to finish): ")
      input.toLowerCase match {
        case "done" => x
        case _ => collectProducts(x :+ input)
      }
    }
    collectProducts(Nil)
  }

  def printProductList(products: List[String]): Unit = {

    products.zipWithIndex.foreach { //pairs each element of the list with its index
      case (product, index) => println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(products: List[String]): Int = {
    products.length
  }

//Question 02
case class Book(title: String, author: String, isbn: String)

var library: mutable.Set[Book] = mutable.Set(
    Book("Gam Peraliya", "Martin Wickramasinghe", "123-4567890123"),
    Book("Magam Soliya", "Mohan Raj Madawala", "123-4567890456"),
    Book("Guru Geethaya", "Chingiz Aitmatov", "123-4567890789")
  )

  def addBook(book: Book): Unit = {
    library += book
    println(s"Added book: ${book.title}")
  }

    def removeBookByISBN(isbn: String): Unit = {
    val bookOption = library.find(_.isbn == isbn)
    bookOption match {
      case Some(book) =>
        library -= book
        println(s"Removed book: ${book.title}")
      case None =>
        println(s"No book found with ISBN: $isbn")
    }
  }

    def isBookInLibrary(isbn: String): Boolean = {
       library.exists(_.isbn == isbn)
  }

    def displayLibrary(): Unit = {
    println("Current Library Collection:")
    library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
  }

    def searchBookByTitle(title: String): Unit = {
    val bookOption = library.find(_.title.equalsIgnoreCase(title))
    bookOption match {
      case Some(book) =>
        println(s"Found book: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None =>
        println(s"No book found with title: $title")
    }
  }

    def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.nonEmpty) {
      println(s"Books by $author:")
      booksByAuthor.foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
    } else {
      println(s"No books found by author: $author")
    }
  }


//Question 03
def fibonacci(n:Int):Int= n match{
case 0 => 0
case x if x==1 => 1
case _ => fibonacci(n-1)+fibonacci(n-2)
}
def fibonacciSeq(n:Int):Unit= {
if (n > 0) fibonacciSeq(n-1)
println(fibonacci(n))
}


@main def main() : Unit={
    
    //q1
    printf("Question 01\n\n")
    val products = getProductList()
    printProductList(products)
    println(s"Total number of products: ${getTotalProducts(products)}")

    //q2
    printf("\n\nQuestion 02\n\n")
    displayLibrary()
    println()

    addBook(Book("Rajina", "Mohan Raj Madawala", "123-4567891011"))
    displayLibrary()
    println()

    removeBookByISBN("123-4567890456")
    displayLibrary()
    println()

    println(s"Is 'Gam Peraliya' in the library? ${isBookInLibrary("123-4567890123")}")
    println(s"Is 'Harry Potter' in the library? ${isBookInLibrary("123-4567891122")}")
    println()

    searchBookByTitle("Gam Peraliya")
    searchBookByTitle("Famous Five")
    println()

    displayBooksByAuthor("Mohan Raj Madawala")
    displayBooksByAuthor("J.K. Rowling")

    //q3
    printf("\n\nQuestion 03\n\n")
    fibonacciSeq(8)

  
}

