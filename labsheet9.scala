import scala.io.StdIn.readInt

//Question 01
  val calculateInterest: Double => Double = depositAmount => {
    if (depositAmount <= 20000) {
      depositAmount * 0.02
    } else if (depositAmount <= 200000) {
      depositAmount * 0.04
    } else if (depositAmount <= 2000000) {
      depositAmount * 0.035
    } else {
      depositAmount * 0.065
    }
  }

  //Question 02
    val classifyNumber: Int => String = number => number match {
    case n if n <= 0   => "Negative/Zero is input"
    case n if n % 2 == 0 => "Even number is given"
    case _              => "Odd number is given"
  }

  //Question 03
    def toUpper(str: String): String = str.toUpperCase

    def toLower(str: String): String = str.toLowerCase

    def formatNames(name: String)(formatFunction: String => String): String = {
    formatFunction(name)
    }

 @main def main(): Unit = {
//q1
    printf("Question 01\n\n")
    val deposits = List(15000, 50000, 500000, 3000000)
    deposits.foreach { deposit =>
      println(s"Deposit Amount: Rs. $deposit => Interest Earned: Rs. ${calculateInterest(deposit)}")
    }

//q2
    printf("\n\nQuestion 02\n\n")
    println("Please enter an integer:")
    val input = readInt()

    println(classifyNumber(input))

//q3
    printf("\n\nQuestion 03\n\n")


    val name1 = "Benny"
    val name2 = "Niroshan"
    val name3 = "Saman"
    val name4 = "Kumara"

    println(formatNames(name1)(toUpper))         // BENNY
    println(formatNames(name2)(name => name.substring(0, 2).toUpperCase + name.substring(2).toLowerCase)) // NIroshan
    println(formatNames(name3)(toLower))         // saman
    println(formatNames(name4)(name => name.substring(0, 1).toUpperCase + name.substring(1, name.length - 1).toLowerCase + name.substring(name.length - 1).toUpperCase)) // KumarA
  
 }