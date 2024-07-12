import scala.io.StdIn._

//Question 01
  var itemNames: Array[String] = Array("Keyboards", "Headphones", "Pendrives")
  var itemQuantities: Array[Int] = Array(10, 15, 20)

  def displayInventory(): Unit = {
    println("Inventory:")
    for (i <- itemNames.indices) {
      println(s"${itemNames(i)}: ${itemQuantities(i)}")
    }
  }

  def restockItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index >= 0) {
      itemQuantities(index) += quantity
      println(s"Restocked $quantity pieces of $itemName. New quantity: ${itemQuantities(index)}")
    } else {
      println(s"Item $itemName doesn't exist in the inventory.")
    }
  }

  def sellItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index >= 0) {
      if (itemQuantities(index) >= quantity) {
        itemQuantities(index) -= quantity
        println(s"Sold $quantity  pieces of $itemName. New quantity: ${itemQuantities(index)}")
      } else {
        println(s"Not enough $itemName in the inventory to sell $quantity pieces. Current quantity: ${itemQuantities(index)}")
      }
    } else {
      println(s"Item $itemName doesn't exist in the inventory.")
    }
  }

//Question 02
def checkNum(num : Int) : Unit = num  match {

    case  x if x <= 0 => println("Negative/Zero")
    case x if x%2 == 1 => println("Odd Number is given")
    case _ => println("Even Number is given")

}

//Question 03
def toUpper(s: String) : String = {
  s.map{ c=>
    if(c >= 'a' && c <= 'z'){
      (c-32).toChar
    }
    else{
      c
    }
  }
}

def toLower(s: String) : String = {
  s.map{c=>
    if(c >= 'A' && c<= 'Z'){
      (c+32).toChar 
    }
    else{
      c
    }
  }
}

def formatNames(name: String)(format: String => String): String = {
    format(name)
  }

def formatNiroshan(name: String): String = {
    toUpper(name.substring(0, 2)) + name.substring(2)
    }

def formatKumara(name: String): String = {
  toUpper(name.substring(0, 1)) + toLower(name.substring(1, name.length - 1)) + toUpper((name.last).toString())
}

  @main def main(): Unit = {

    //Q1
    printf("Question 01 :\n")  
    displayInventory()

    restockItem("Keyboards", 5)
    restockItem("Headphones",10)
    restockItem("SDcard",10)

    sellItem("Headphones", 10)
    sellItem("Keyboards", 20)

    displayInventory()

    //Q2
    printf("\n\nQuestion 02 :\nEnter an integer:")        
    val num = readInt()
    checkNum(num)

    //Q3
    printf("\n\nQuestion 03 :\n")
    printf(toUpper("benny\n"))
    printf(formatNames("niroshan\n")(formatNiroshan))
    printf(toLower("saman\n"))
    printf(formatNames("kumara\n")(formatKumara))

  }


