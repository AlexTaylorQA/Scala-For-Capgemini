/**
  * Created by Administrator on 19/07/2017.
  */
object Main {
  def main(args:Array[String]):Unit = {
    val getWord = scala.io.StdIn.readLine()
    cypher(getWord, "", 0)
  }

  def cypher(getWord:String, inString:String, x:Int):Unit = {
    x == getWord.length match {
      case true => println(inString)
      case false =>
        val aBet = "abcdefghijklmnopqrstuvwxyz".toList
        val zBet = aBet.reverse
        val outString = inString +
          {
            getWord.charAt(x) match {
              case _ if (aBet.contains(getWord.charAt(x))) => zBet(aBet.indexOf(getWord.charAt(x)))
              case _ => getWord.charAt(x)
            }
          }
        cypher(getWord, outString, x + 1)
    }
  }
}
