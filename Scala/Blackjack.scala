import scala.collection.mutable.ListBuffer

/**
  * Created by Administrator on 06/06/2017.
  */
object Main
{
  def main(args:Array[String]) =
  {
    var x = 22
    var y = 20

    var a = 1
    var b = 2
    var c = 3

    // Blackjack
    println(blackjack(x, y) + " is the highest score.")

    // UniqueSum
    println("The total sum is " + uniqueSum(a,b,c) + ".")

    // TooHot
    println(tooHot(70, false))

    // Calculator

    // Input (3 nums)
    calc("5, 3, 15")
    calc("4, 2, 8")
    calc("6, 2, 12")
    calc("6, 2, 3")
    calc("9, 12, 108")
    calc("5, 3, 15")

    // Input (4 nums)
    calc("3, 5, 5, 3")
    calc("2, 4, 6, 3")
    calc("1, 1, 2, 3")
    calc("4, 4, 3, 4")
    calc("8, 4, 3, 6")
    calc("9, 3, 1, 7")
    calc("2, 4, 0, 2")
  }

  def blackjack (int1: Int, int2: Int): Int =
  {
    int1 > 0 && int2 > 0 match
    {
      case false => 0
      case true => (int1 > 21 && int2 > 21) match
      {
        case true => 0
        case false => (int1 > 21 && int2 <= 21) match
        {
          case true => int2
          case false => (int2 > 21 && int1 <= 21) match
          {
            case true => int1
            case false => (int1 > int2) match
            {
              case true => int1
              case false => int2
            }
          }
        }
      }
    }
  }

  def uniqueSum(int1: Int, int2: Int, int3: Int): Int =
  {
    int1 == int2 && int2 == int3 match{
      case true => 0
      case false => int1 == int2 match {
        case true => int3
        case false => int2 == int3 match{
          case true => int1
          case false => int1 == int3 match{
            case true => int2
            case false => (int1 + int2 + int3)
          }
        }
      }
    }
  }

  def tooHot(temperature: Int, isSummer: Boolean): Boolean =
  {
    (temperature, isSummer) match
    {
      case(temperature, isSummer) if(temperature >= 60 && temperature <= (if(isSummer) 100 else 90)) => true
      case _ => false
    }
  }

  def calc(x : String): Unit ={
    val temp : Array[String] = x.split(", ")
    var numList : ListBuffer[Int] = ListBuffer()

    for(z <- 0 to temp.size -1){
      numList+=temp(z).toInt

    }

    for(i<-0 to numList.size -1){
      var num1 = numList(i%numList.size)
      var num2 = numList((i+1)%numList.size)
      var num3 = numList((i+2)%numList.size)

      if(num1 + num2 == num3) {
        println(num1 + " + " + num2 + " = " + num3)
      }
      if(num1 * num2 == num3) {
        println(num1 + " x " + num2 + " = " + num3)
      }
      if(num2!=0)
        if(num1 / num2 == num3 && num1 % num2 == 0) {
          println(num1 + " / " + num2 + " = " + num3)
        }
      if (num1!= num2)
      if(num1 - num2 == num3) {
        println(num1 + " + " + num2 + " = " + num3)
      }

    }
    println()
  }

}
