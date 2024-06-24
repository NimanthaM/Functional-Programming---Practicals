object Main extends App{
var a: Int = 2
var b: Int = 3
var c: Int = 4
var d: Int = 5
var k: Float = 4.3f
var g=4.0f

b-=1

printf("Value of --b*a+c*d-- is: %d\n", b*a+c*d)

println(s"Value of a: $a")
a+=1
println(s"value after increment of a (a++) is: $a")

printf("Value of -2*(g-k)+c is: %f\n",-2*(g-k)+c)

println(s"Value of c: $c")
c+=1
println(s"value after increment of c (c++) is: $c")

printf("Value of ++c*a++ is: %d\n", c*a)

}

