/**
  * Created by Administrator on 03/08/2017.
  */
object thePrints {
  def theWelcome()={
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
  }

  def printWin()={
    println("")
    println("------")
    println("|  |")
    println("| (_)")
    println("|       \\_O_/")
    println("|         |    ")
    println("|_____  _/ \\_")

    println("\nYou win! Success!")

    println("\nTry again? Y/N\n")
  }

  def printHang(hangCount: Int) = {
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
