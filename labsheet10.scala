//Question 01
class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  private val g = gcd(n.abs, d.abs)
  val numerator: Int = n / g
  val denominator: Int = d / g

  def this(n: Int) = this(n, 1)

  override def toString: String = s"$numerator/$denominator"

  def neg: Rational = new Rational(-numerator, denominator)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  //Question 02
  def sub(that: Rational): Rational = {
    val newNumerator = this.numerator * that.denominator - that.numerator * this.denominator
    val newDenominator = this.denominator * that.denominator
    new Rational(newNumerator, newDenominator)
  }
  
}

  //Question 03
  class Account(var balance: Double) {
    def deposit(amount: Double): Unit = {
      balance += amount
    }

    def withdraw(amount: Double): Unit = {
      if (amount > balance) 
        throw new IllegalArgumentException("Insufficient funds")
      balance -= amount
    }

    def transfer(amount: Double, to: Account): Unit = {
      this.withdraw(amount)
      to.deposit(amount)
    }

    override def toString: String = f"Balance: $$ $balance%.2f"
  }

  //Question 04
    object Bank {
  type Accounts = List[Account]

  def accountsWithNegativeBalances(accounts: Accounts): Accounts = 
    accounts.filter(_.balance < 0)

  def totalBalance(accounts: Accounts): Double = 
    accounts.map(_.balance).sum

  def applyInterest(accounts: Accounts): Accounts = {
    accounts.foreach { account =>
      if (account.balance > 0) {
        account.deposit(account.balance * 0.05)
      } else {
        account.balance -= account.balance.abs * 0.1
      }
    }
    accounts
  }
}

    //Question 05
    def countLetterOccurrences(words: List[String]): Int = {
    words.map(_.length).reduce(_ + _)
  }



@main def main(): Unit =
{
    //q1 
    printf("Question 01\n\n")
    val x = new Rational(3, 4)
    val negX = x.neg
    println(negX)

    //q2
    printf("\n\nQuestion 02\n\n")
    val y = new Rational(3, 4)
    val p = new Rational(5, 8)
    val z = new Rational(2, 7)

    val result = y.sub(p).sub(z) // y - p - z
    println(result)

    //q3
    printf("\n\nQuestion 03\n\n")
    val account1 = new Account(1000)
    val account2 = new Account(500)
    account1.transfer(200, account2)
    println(s"Account 1 After Transfer: $account1")
    println(s"Account 2 After Transfer: $account2")

    //q4
    printf("\n\nQuestion 04\n\n")
    val acc1 = new Account(1000)
    val acc2 = new Account(-200)
    val acc3 = new Account(300)
    val bankAccounts = List(acc1, acc2, acc3)
    println(s"Accounts with Negative Balances: ${Bank.accountsWithNegativeBalances(bankAccounts)}")  

    println(s"Total Balance of All Accounts: ${Bank.totalBalance(bankAccounts)}")
    Bank.applyInterest(bankAccounts)
    println(s"Accounts After Applying Interest:")
    bankAccounts.foreach(println)

    //q5
    printf("\n\nQuestion 05\n\n")
    val words = List("apple", "banana", "cherry", "date")
    val totalLetters = countLetterOccurrences(words)
    println(s"Total Count of Letter Occurrences: $totalLetters")
}