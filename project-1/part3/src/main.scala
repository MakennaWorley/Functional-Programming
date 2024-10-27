import java.util.Scanner
import Conversion._

@main
def main(): Unit =
  ()
  // Write code to demonstrate use of Conversion (both the case class and the companion object)
  //   - Create at least one Conversion in this method (by instantiating the case class here)
  //   - Refer to at least one of the Conversions you defined in the companion object
  // Have the user enter a number and run it through these conversions (like if the user types in
  // 212, you can print "212 °F is 100 °C" (where the unit names and the converted value come from
  // using the conversion).

  val KELVIN_TO_CELSIUS: Conversion = Conversion("K", "°C", k => k - 273.15)

  val in = new Scanner(System.in)

  print("Enter a F to change into C: ")
  val inputValue = in.nextDouble

  val output = Conversion.FAHRENHEIT_TO_CELSIUS
  println(s"$inputValue ${output.fromUnit} is ${output.input(inputValue)} ${output.toUnit}")


  //print("Enter a C to change into K: ")
  //val inputValue2 = in.nextDouble

  val output2 = Conversion.CELSIUS_TO_KELVIN
  println(s"$inputValue ${output2.fromUnit} is ${output2.input(inputValue)} ${output2.toUnit}")