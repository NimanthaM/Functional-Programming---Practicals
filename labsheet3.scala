//Question 01

def reverseString(string: String) : String ={
    if(string.isEmpty()) ""
    else reverseString(string.tail) + string.head

}

//Question 02

def filterStrings(strings: List[String]) : List[String] = {
    strings.filter(_.length() > 5)
}

//Question 03

def arthmeticMean(num1 : Int , num2 : Int): Float = {
        var number = (num1 + num2)/2
        return BigDecimal(number).setScale(2, BigDecimal.RoundingMode.HALF_UP).toFloat
    }

//Question 04

def sumOfEven(numbers: List[Int]) : Int = {
    numbers.filter(_%2 == 0).sum
}

@main def main(): Unit= {

    //q1
    printf("Q 01\n\n")
    println("Enter the string what you want to reverse: ")
    val input = scala.io.StdIn.readLine()

    val reversed = reverseString(input)
    println(s"Reversed stirng is: $reversed")

    //q2
    printf("\n\nQ 02\n\n")
    println("Enter the list of strings sepersted by commas: ")
    val input2 = scala.io.StdIn.readLine()

    val stringList = input2.split(",").toList

    val filteredList = filterStrings(stringList)

    println(s"List that contain words with letters more than 5: ${filteredList.mkString(",")}")

    //q3
    printf("\n\nQ 03\n\n")
    var num1 = 15
        var num2 = 25
        println("The arthmetic mean of 15 & 25 is :" + arthmeticMean(num1,num2))

    //q4
    printf("\n\nQ 04n\n\n")
    println("Enter a list of integers separated by commas:")
    val input3 = scala.io.StdIn.readLine()

    val numberList = input3.split(",").map(_.toInt).toList

    val sum = sumOfEven(numberList)

    println(s"Sum of all even numbers in the list is: $sum")
}