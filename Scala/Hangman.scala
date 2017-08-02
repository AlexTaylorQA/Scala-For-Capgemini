import java.sql.{Connection, DriverManager}

/**
  * Created by Administrator on 26/06/2017.
  */
object Main
{
  def main(args: Array[String]): Unit = {
    DBUpdate("CREATE TABLE IF NOT EXISTS wordTable(theID INT(10) PRIMARY KEY AUTO_INCREMENT, theWord VARCHAR(20));")

    DBUpdate("TRUNCATE TABLE wordTable")

    DBUpdate("ALTER TABLE wordTable AUTO_INCREMENT=0")

    DBUpdate("LOAD DATA LOCAL INFILE 'src/main/resources/words_alpha.txt' INTO TABLE wordTable(theWord);")

    var theWord = ""

    var gameSwitch = 0

    println("")
    println("        ==========================================================")
    println("        **********************************************************")
    println("        ==========================================================")
    println("         __     __   ____   _      ____   ____   ___   ___   ____ ")
    println("        |  | _ |  | |  __| | |    |  __| |    | |   \\ /   | |  __|")
    println("        |  |/ \\|  | |  _|  | |__  | |__  | || | |  |\\_/|  | |  _| ")
    println("        |___/ \\___| |____] |____| |____| |____| |__|   |__| |____]  ")
    println("")
    println("        ==========================================================")
    println("        **********************************************************")
    println("        ==========================================================")


    println("\n------")
    println("|  |")
    println("| (_) ")
    println("|")
    println("|")
    println("|_____")

    while (gameSwitch == 0)
    {

      var endSwitch: Int = 0
      var hangCount: Int = 0
      var usedLetters = ""

      var wordGetSwitch = 0
      while (wordGetSwitch == 0) {
        theWord = DBRead("SELECT * FROM wordTable WHERE theID = (SELECT FLOOR(RAND() * (SELECT COUNT(theID) FROM wordTable) + 1));")
        theWord.length <= 0 match {
          case true =>
          case false =>
            wordGetSwitch = 1
        }

      }
    while (endSwitch == 0) {
      println("")

      hangCount match {
        case 6 =>
          println("\nYou get NOTHING! You LOSE! Good DAY sir!")
          println("\n(The word was '" + {
            var outString: String = ""
            for (t <- 0 to theWord.toCharArray.length - 2) {
              outString += theWord.toCharArray.charAt(t).toString
            }
            outString
          } + "', stupid.)")


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

              println("")
              println("------")
              println("|  |")
              println("| (_)")
              println("|       \\_O_/")
              println("|         |    ")
              println("|_____  _/ \\_")

              println("\nYou win! Success!")



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


            case true =>

              (6 - hangCount) match {
                case 1 =>
                  println("\n" + (6 - hangCount + " mistake and you hang!\n\n" + {
                    for (w <- 0 to hideWord.length - 2) {
                      outWord += hideWord(w).toString + " "
                    };
                    outWord
                  }))

                case _ =>
                  println("\n" + (6 - hangCount + " mistakes and you hang!\n\n" + {
                    for (w <- 0 to hideWord.length - 2) {
                      outWord += hideWord(w).toString + " "
                    };
                    outWord
                  }))
              }


              println("\nYou have used the following letters: " + usedLetters)

              println("\nPlease choose a letter.\n")
              var input: String = scala.io.StdIn.readLine()

              usedLetters += input

              theWord.toCharArray.contains(input.charAt(0)) match {
                case false => hangCount += 1
                case true =>
              }

              hangCount match {
                case 0 =>
                  println("------")
                  println("|  |")
                  println("| (_)")
                  println("|")
                  println("|")
                  println("|_____")

                case 1 =>
                  println("------")
                  println("|  |")
                  println("|  O")
                  println("|")
                  println("|")
                  println("|_____")

                case 2 =>
                  println("------")
                  println("|  |")
                  println("|  O")
                  println("|  |")
                  println("|")
                  println("|_____")

                case 3 =>
                  println("------")
                  println("|  |")
                  println("|  O")
                  println("| /|")
                  println("|")
                  println("|_____")

                case 4 =>
                  println("------")
                  println("|  |")
                  println("|  O")
                  println("| /|\\")
                  println("|")
                  println("|_____")

                case 5 =>
                  println("------")
                  println("|  |")
                  println("|  O")
                  println("| /|\\")
                  println("| / ")
                  println("|_____")

                case 6 =>
                  println("------")
                  println("|  |")
                  println("|  O")
                  println("| /|\\")
                  println("| / \\")
                  println("|_____")

              }
          }
      }
    }

  }
}

def DBUpdate(inQ:String) =
{
// Connects Scala Object 'Main' to the SQL Database.

val url = "jdbc:mysql://192.168.1.49:3306/hangmanDB"
val driver = "com.mysql.jdbc.Driver"
val username = "root"
val password = "merdegraw494"
var connection:Connection = DriverManager.getConnection(url, username, password)
try {
Class.forName(driver)

connection = DriverManager.getConnection(url, username, password)
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

val url = "jdbc:mysql://192.168.1.49:3306/hangmanDB"
val driver = "com.mysql.jdbc.Driver"
val username = "root"
val password = "merdegraw494"
var connection:Connection = DriverManager.getConnection(url, username, password)

var theID:Int = 0
var theWord:String = ""

try {
Class.forName(driver)

connection = DriverManager.getConnection(url, username, password)
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
}
