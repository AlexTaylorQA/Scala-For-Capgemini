
import scala.annotation.tailrec

object Main {

  type LongFormat = String
  type ShortFormat = String


  val shortList: List[ShortFormat] = List(" ","thousand","million","billion",
    "trillion","quadrillion","quintillion","sextillion")

  val longList: List[LongFormat] = List(" ","thousand","million","milliard",
    "billion","billiard","trillion","trilliard")

  val shortFormat: Int =>String = (index: Int) =>  shortList(index)

  val longFormat: Int => String = (index: Int) =>  longList(index)


  def main(args: Array[String]): Unit = {
    val num = getInput(0)
    println("Short format is: " + getFormat(num)(shortFormat))
    println("Long format is: " + getFormat(num)(longFormat))
  }

  @tailrec
  def getInput(count: Int): BigInt = {

    val input = util.Try(BigInt(readLine("Please input a number: ")))

    input match {
      case util.Success(v) => v
      case util.Failure(e) =>
        println("Error: invalid value.")
        count + 1 match{
          case x if x>=3 => 0
          case x => getInput(x)
        }
    }
  }

  def getFormat(num: BigInt)(format: Int=>String): String ={
    if(num.toString.length<=(shortList.length*3)) {
      val orderedNumber = num.toString.reverse.grouped(3).toList
      val len = orderedNumber.length - 1

      orderedNumber.reverse.zipWithIndex.map{case (x,y) => {
        val resString = x.reverse
        if(resString!="000") {
          val resFormat = format(len - y)
          s"${resString.replaceFirst("^0+(?!$)","")} $resFormat "
        }else{
          ""
        }
      }}.mkString("").trim

    }else{
      "Sorry, index is out of range."
    }
  }

}
