//Question 03
def salary(normalH: Int, otH: Int): Double={

    if(normalH>=40 && otH>=30){
        (((normalH*250.0) + (otH*85.0))*88.0/100)*4.0 
    }else{
        (normalH*250.0) + (otH*85.0) 
    }
}

//Question 04
def attendees(price: Int): Int ={
    120 + (15-price)/5*20
}

def revenue(price: Int): Int = {
    attendees(price)*price
}

def cost(price: Int): Int = {
    500 + 3*attendees(price)
}

def profit(price: Int): Int = {
    revenue(price) - cost(price)
}

@main def main(): Unit={
    printf("Q 03\n\n")
    printf("Total salary is: %f\n\n",salary(40,30))

    printf("Q 04\n\n")
    printf("Profit of ticket prices 20,25,30 & 35:\n20: %d\n25: %d\n30: %d\n35: %d\n",profit(20),profit(25),profit(30),profit(35))

}