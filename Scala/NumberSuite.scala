import org.scalatest.FunSuite
import util._
import java.io.StringBufferInputStream
import scala.Console.setIn

/**
  * Created by Administrator on 18/07/2017.
  */

class NumberSuite extends FunSuite
{

  test("Input a valid number (shortform).")
  {
    Main.getFormat(1234567890)(Main.shortFormat)
  }

  test("Input a valid number (longform).")
  {
    Main.getFormat(1234567890)(Main.longFormat)
  }

  test("Input a negative number.")
  {
    Main.getFormat((-1234567890))(Main.longFormat)
  }

  test("Input zero.")
  {
    Main.getFormat(0)(Main.shortFormat)
  }
  
  test("Input an invalid string instead of a number.")
  {
    val error = intercept[Exception] {Main.getFormat("abc".toLong)(Main.shortFormat)}
    assert(error.getMessage === "For input string: \"abc\"")
  }

  test("Try to input a number with a sequence of zeroes in the scope of \"thousand\", \"million\", etc (shortformat).")
  {
    Main.getFormat(1000000000)(Main.shortFormat)
  }

  test("Try to input a number with a sequence of zeroes in the scope of \"thousand\", \"million\", etc (longformat).")
  {
    Main.getFormat(1000000000)(Main.longFormat)
  }

  test("Try to input a number with more digits than 'BigInt' can handle (i.e. out of range index). Program should catch this.")
  {
    Main.getFormat(BigInt("1234567898765432123456789876543212345678987654321"))(Main.shortFormat)
  }

}

