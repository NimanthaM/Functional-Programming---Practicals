//Question 01
val Pi = 3.14159

def areaOfDisk(r : Double): Double = {
    Pi * r * r
}

val area = areaOfDisk(5)

//Qustion 02
def convertTemp(C: Double): Double = {
     C*1.8000 + 32.00
}

val F = convertTemp(35)

//Question 03
def volumeOfSphere(r : Double) : Double ={
    4/3*Pi*r*r*r
}

val volume = volumeOfSphere(5)

//Question 04
def discountedPrice(coverPrice : Double, discount :  Double, numOfcopies: Int) : Double = {
    coverPrice*(1-discount)*numOfCopies
}

def totalShipping(numOfCopies: Int): Double = {
    if(numOfCopies <= 50){
        3
    }
    else{
        3 + (numOfCopies-50)*0.75
    }
}

val totalCost= discountedPrice(24.95,0.4) + totalShipping(60)

//Question 05
def calculateTime(pace: Double, distance: Double): Double = {
    pace*distance
}
def totalTime(easyPace: Double, tempoPace: Double, easyDistance1: Double, tempoDistance: Double, easyDistance2: Double): Double = {
    val easyTime1 = calculateTime(easyPace,easyDistance1)
    val tempoTime = calculateTime(tempoPace,tempoDistance)
    val easyTime2 = calculateTime(easyPace,easyDistance2)

    easyTime1+tempoTime+easyTime2
}
val totalRunningTime = totalTime(8,7,2,3,2)

def main(args: Array[String]): Unit={
    println("Q1")
    println(s"Area of disk with radius 5 is  : $area\n")

    println("Q2")
    println(s"Farenheit value of the 35C is : $F\n")

    println("Q3")
    println(s"Volume of a sphere with radius 5 is : $volume\n")

    println("Q4")
    println(s"Total wholesale cost : $totalCost\n")

    println("Q5")
    println(s"Total running time is : $totalRunningTime")
}
