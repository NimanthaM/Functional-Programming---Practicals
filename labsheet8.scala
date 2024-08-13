import scala.io.StdIn
//Question 01
def encrypt(text: String, shift: Int): String = {
  text.map { c =>
    if (c.isUpper) {
      ((c - 'A' + shift) % 26 + 'A').toChar
    } else if (c.isLower) {
      ((c - 'a' + shift) % 26 + 'a').toChar
    } else {
      c
    }
  }
}

// Decryption
def decrypt(text: String, shift: Int): String = {
  text.map { c =>
    if (c.isUpper) {
      ((c - 'A' - shift + 26) % 26 + 'A').toChar
    } else if (c.isLower) {
      ((c - 'a' - shift + 26) % 26 + 'a').toChar
    } else {
      c
    }
  }
}

def cipher(processFunction: (String, Int) => String, text: String, shift: Int): String = {
  processFunction(text, shift)
}


//Question 02

val multipleOfThree: Int => Boolean = (x: Int) => x % 3 == 0
val multipleOfFive: Int => Boolean = (x: Int) => x % 5 == 0
val multipleOfBoth: Int => Boolean = (x: Int) => x % 3 == 0 && x % 5 == 0

def categorizeNumber(num: Int): String = num match {
    case n if multipleOfBoth(n) => "Multiple of Both Three and Five"
    case n if multipleOfThree(n) => "Multiple of Three"
    case n if multipleOfFive(n) => "Multiple of Five"
    case _ => "Not a Multiple of Three or Five"
}

@main def main (): Unit = {

//q1
printf("Question 01\n\n")
val text = "Hello, World!"
val shift = 2

val encryptedText = cipher(encrypt, text, shift)
println(s"Encrypted: $encryptedText")

val decryptedText = cipher(decrypt, encryptedText, shift)
println(s"Decrypted: $decryptedText")

//q2
printf("\n\nQuestion 02\n\n")
println("Enter an integer:")
val input = StdIn.readInt()

println(categorizeNumber(input))
}
