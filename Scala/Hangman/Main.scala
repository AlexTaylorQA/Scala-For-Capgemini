import java.sql.{Connection, DriverManager}

import scala.collection.mutable

/**
  * Created by Administrator on 26/06/2017.
  */
object Main
{
  def main(args: Array[String]): Unit = {
    DBHandler()
    var gameSwitch = 0
    thePrints.theWelcome()

    while (gameSwitch == 0)
    {
      var endSwitch: Int = 0
      var hangCount: Int = 0
      var usedLetters = ""

    var theWord = getWord()

    while (endSwitch == 0) {
      println("")

      hangCount match {
        case 6 =>
          val checkLoss = gameLoss(false, theWord, gameSwitch, endSwitch)
          gameSwitch = checkLoss._1
          endSwitch = checkLoss._2

        case _ =>

          var hideWord = theWord.toBuffer

          for (z <- 0 to hideWord.length - 1) {
            hideWord(z) = '_'
          }

          var outWord: String = ""

          for (y <- 0 to theWord.length - 1) {
            for (x <- 0 to usedLetters.length - 1) {
              if (usedLetters.charAt(x) == theWord.charAt(y)) {
                hideWord(y) = usedLetters.charAt(x)
              }
            }
          }

          var checkWord = ""
          for (u <- 0 to hideWord.length - 2) {
            checkWord += hideWord(u).toString
          }

          checkWord matches ".*_.*" match {

            case false =>

              val checkWin = gameLoss(true, theWord, gameSwitch, endSwitch)
              gameSwitch = checkWin._1
              endSwitch = checkWin._2


            case true =>

              (6 - hangCount) match {
                case 1 =>
                  theOutWord(hangCount, hideWord, outWord, "mistake")
                case _ =>
                  theOutWord(hangCount, hideWord, outWord, "mistakes")
              }

              println("\nYou have used the following letters: " + usedLetters)

              println("\nPlease choose a letter.\n")
              var input: String = scala.io.StdIn.readLine()

              usedLetters += input

              theWord.toCharArray.contains(input.charAt(0)) match {
                case false => hangCount += 1
                case true =>
              }
              thePrints.printHang(hangCount)
          }
      }
    }

  }
}

  def DBHandler() = {
    DBUpdate("CREATE TABLE IF NOT EXISTS wordTable(theID INT(10) PRIMARY KEY AUTO_INCREMENT, theWord VARCHAR(20));")
    DBUpdate("TRUNCATE TABLE wordTable")
    DBUpdate("ALTER TABLE wordTable AUTO_INCREMENT=0")
    DBUpdate("LOAD DATA LOCAL INFILE 'src/main/resources/words_alpha.txt' INTO TABLE wordTable(theWord);")
  }

def DBUpdate(inQ:String) =
{
// Connects Scala Object 'Main' to the SQL Database.
  var getConnection = DBcon.dbConnection()
  var connection:Connection = getConnection._1

try {
Class.forName(getConnection._2)

val statement = connection.createStatement

// Connection strings go here
statement.executeUpdate(inQ)

} catch {
case e: Exception => e.printStackTrace
}
connection.close
}

def DBRead(inQ:String):String =
{
// Connects Scala Object 'Main' to the SQL Database.

  var getConnection = DBcon.dbConnection()
  var connection:Connection = getConnection._1

var theID:Int = 0
var theWord:String = ""

try {
Class.forName(getConnection._2)

val statement = connection.createStatement

// Connection strings go here
var output = statement.executeQuery(inQ)
while(output.next)
{
 theWord = output.getString("theWord")
}

} catch {
case e: Exception => e.printStackTrace
}
connection.close

theWord

}

  def getWord():String = {
    var theWord = ""
    var wordGetSwitch = 0
    while (wordGetSwitch == 0) {
      theWord = DBRead("SELECT * FROM wordTable WHERE theID = (SELECT FLOOR(RAND() * (SELECT COUNT(theID) FROM wordTable) + 1));")
      theWord.length <= 0 match {
        case true =>
        case false =>
          wordGetSwitch = 1
      }

    }
    theWord
  }

  def gameLoss(winLoss: Boolean, theWord: String, inGSwitch:Int, inESwitch:Int):(Int,Int) = {
    var gameSwitch = inGSwitch
    var endSwitch = inESwitch

    winLoss match {
      case true =>
        thePrints.printWin()
        var newGame: String = scala.io.StdIn.readLine().toLowerCase()
        newGame match
        {
          case "y" =>
          case _ =>
            println("\nGoodbye. Try again some other time!\n")
            gameSwitch = 1
        }
        endSwitch = 1
      case false =>
        println("\nYou lose!")
        println("\n(The word was '" + {
          var outString: String = ""
          for (t <- 0 to theWord.toCharArray.length - 2) {
            outString += theWord.toCharArray.charAt(t).toString
          }
          outString
        } + "'.)")


        println("\nTry again? Y/N\n")
        var newGame: String = scala.io.StdIn.readLine().toLowerCase()
        newGame match
        {
          case "y" =>
          case _ =>
            println("\nGoodbye. Try again some other time!\n")
            gameSwitch = 1
        }
        endSwitch = 1
    }
    (gameSwitch, endSwitch)
  }

  def theOutWord(hangCount:Int, hideWord:mutable.Buffer[Char], inWord:String, plural:String) = {
    var outWord = inWord
    println("\n" + (6 - hangCount + plural + " and you hang!\n\n" + {
      for (w <- 0 to hideWord.length - 2) {
        outWord += hideWord(w).toString + " "
      };
      outWord
    }))
  }
}
