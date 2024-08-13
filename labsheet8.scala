object CaesarCipher {

  def encrypt(text: String, shift: Int): String = {
    text.map {
      case c if c.isUpper =>
        ((c - 'A' + shift) % 26 + 'A').toChar
      case c if c.isLower =>
        ((c - 'a' + shift) % 26 + 'a').toChar
      case c => c
    }
  }

  def decrypt(text: String, shift: Int): String = {
    text.map {
      case c if c.isUpper =>
        ((c - 'A' - shift + 26) % 26 + 'A').toChar
      case c if c.isLower =>
        ((c - 'a' - shift + 26) % 26 + 'a').toChar
      case c => c
    }
  }
}
