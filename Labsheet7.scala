//Question 01
def filterEvenNumbers(numbers: List[Int]): List[Int] = {
  numbers.filter(n => n % 2 == 0)
}

//Question 02
def calculateSquare(numbers: List[Int]): List[Int] = {
    numbers.map(n=> n*n)
}

//Question 03
def isPrime(n: Int): Boolean = {
  if (n <= 1) false
  else if (n == 2) true
  else !(2 to scala.math.sqrt(n).toInt).exists(x => n % x == 0)
}

def filterPrime(numbers: List[Int]): List[Int] = {
  numbers.filter(isPrime)
}

@main def main():Unit = {
//q1
printf("Question 01\n")
val evenNumbers = filterEvenNumbers(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
println(evenNumbers) 

//q2
printf("\n\nQuestion 02\n")
val squaredNumbers = calculateSquare(List(1,2,3,4,5))
println(squaredNumbers)

//q3
printf("\n\nQuestion 03\n")
val primeNumbers = filterPrime(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
println(primeNumbers) 
}