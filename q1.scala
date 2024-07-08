
  var itemNames: Array[String] = Array("Apples", "Bananas", "Oranges")
  var itemQuantities: Array[Int] = Array(10, 20, 15)

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
      println(s"Restocked $quantity of $itemName. New quantity: ${itemQuantities(index)}")
    } else {
      println(s"Item $itemName does not exist in the inventory.")
    }
  }

  def sellItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index >= 0) {
      if (itemQuantities(index) >= quantity) {
        itemQuantities(index) -= quantity
        println(s"Sold $quantity of $itemName. New quantity: ${itemQuantities(index)}")
      } else {
        println(s"Not enough $itemName in inventory to sell $quantity. Current quantity: ${itemQuantities(index)}")
      }
    } else {
      println(s"Item $itemName does not exist in the inventory.")
    }
  }

  @main def main(): Unit = {
    displayInventory()
    restockItem("Apples", 5)
    sellItem("Bananas", 10)
    sellItem("Oranges", 20)
    displayInventory()
  }


