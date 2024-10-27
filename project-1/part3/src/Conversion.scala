// Write a case class that represents a conversion from one unit to another — that is,
// it should have three values:
//   - the symbol of the "from" unit (like °F)
//   - the symbol of the "to" unit (like °C)
//   - a function that converts "from"→"to" (like C = 5/9 (F - 32))

case class Conversion(fromUnit: String, toUnit: String, input: Double => Double)

// Since we have both a class and an object with the same name (Conversion), these are called
// *companions* of each other - this is the Scala equivalent of having both non-static stuff
// (from the class) and static stuff (from the object).
//
// So we can instantiate Conversion in the usual way (using the case class):
//     val someConversion = Conversion(...)
// we can call methods on those conversions:
//     someConversion.toString()
// and we can also access stuff in the Conversion *object* just like static things in Java:
//     Conversion.FAHRENHEIT_TO_CELSIUS

object Conversion {
  // fill this in
  val FAHRENHEIT_TO_CELSIUS: Conversion = Conversion("°F", "°C", f => (f - 32) * 5 / 9)
  // make sure to provide the function as a lambda - don't just pass in a function you define elsewhere!

  // add at least two more of your choice

  val CELSIUS_TO_FAHRENHEIT: Conversion = Conversion("°C", "°F", c => (c * 9 / 5) + 32)

  val CELSIUS_TO_KELVIN: Conversion = Conversion("°C", "K", c => c + 273.15)
}