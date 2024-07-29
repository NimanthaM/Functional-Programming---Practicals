import scala.io.StdIn.readLine

//Question 01
case class Product(id: Int, name: String, quantity: Int, price: Double)

val inventory1: Map[Int, Product] = Map(
    1001 -> Product(1001, "Keyboard", 50, 1500.0),
    1002 -> Product(1002, "Mouse", 30, 850.0),
    1003 -> Product(1003, "Pen drive", 20, 800.0)
  )

  val inventory2: Map[Int, Product] = Map(
    1002 -> Product(1002, "Mouse", 20, 950.0),
    1004 -> Product(1004, "SSD", 10, 4500.0)
  )

  def getAllProductNames(inventory: Map[Int, Product]): List[String] = {
    inventory.values.map(_.name).toList
  }

  def calculateTotalValue(inventory: Map[Int, Product]): Double = {
    inventory.values.map(product => product.quantity * product.price).sum
  }

  def isInventoryEmpty(inventory: Map[Int, Product]): Boolean = {
    inventory.isEmpty
  }

  def mergeInventories(inventory1: Map[Int, Product], inventory2: Map[Int, Product]): Map[Int, Product] = {
    inventory2.foldLeft(inventory1) { case (acc, (id, product)) =>
      acc.get(id) match {
        case Some(existingProduct) =>
          acc.updated(id, existingProduct.copy(
            quantity = existingProduct.quantity + product.quantity,
            price = Math.max(existingProduct.price, product.price)
          ))
        case None =>
          acc + (id -> product)
      }
    }
  }

  def checkAndPrintProductDetails(inventory: Map[Int, Product], productId: Int): Unit = {
    inventory.get(productId) match {
      case Some(product) =>
        println(s"Product found: ID=${product.id}, Name=${product.name}, Quantity=${product.quantity}, Price=${product.price}")
      case None =>
        println(s"Product with ID $productId not found.")
    }
  }

//Question 02

def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.isEmpty){
        (false, Some("Name can't be empty"))
    }else if(marks<0){
        (false, Some("Marks can't be negative"))
    }else if(marks> totalMarks){
        (false, Some("Marks can't exeed the total marks"))
    }else{
        (true,None)
    }
}

  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    println("Enter student's name:")
    val name = readLine()
    println("Enter marks obtained:")
    val marks = readLine().toInt
    println("Enter total possible marks:")
    val totalMarks = readLine().toInt

    val percentage = (marks.toDouble / totalMarks) * 100

    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _ => 'D'
    }

    (name, marks, totalMarks, percentage, grade)
  }

    def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Student Name: $name")
    println(s"Marks Obtained: $marks")
    println(s"Total Possible Marks: $totalMarks")
    println(s"Percentage: $percentage%")
    println(s"Grade: $grade")
  }

def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var validInput = false
    var studentInfo: (String, Int, Int, Double, Char) = null

    while (!validInput){
        val info = getStudentInfo()
        val (name, marks, totalMarks, _, _) = info
        val (isValid, errorMessage) = validateInput(name, marks, totalMarks)
        if(isValid){
            validInput = true
            studentInfo = info
        }else{
            println(s"Invalid input: ${errorMessage.get}")
        }
    }

    studentInfo
}

  @main def main():Unit = {

//Q 01
  println("All product names in inventory1:")
  println(getAllProductNames(inventory1))
  println()

  println("Total value of all products in inventory1:")
  println(calculateTotalValue(inventory1))
  println()

  println("Is inventory1 empty?")
  println(isInventoryEmpty(inventory1))
  println()

  println("Merged inventory1 and inventory2:")
  val mergedInventory = mergeInventories(inventory1, inventory2)
  mergedInventory.foreach { case (id, product) =>
    println(s"ID=$id, Name=${product.name}, Quantity=${product.quantity}, Price=${product.price}")
  }
  println()

  println("Check and print details for product ID 1002 in inventory1:")
  checkAndPrintProductDetails(inventory1, 1002)
  println()

//Q 02
val studentRecord = getStudentInfoWithRetry()
printStudentRecord(studentRecord)

}

