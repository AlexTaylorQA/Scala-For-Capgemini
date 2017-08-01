/**
  * Created by Administrator on 12/06/2017.
  */

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

class Garage(var isOpen:Boolean)
{
  var vBuff = scala.collection.mutable.ArrayBuffer.empty[Vehicle]
  var eBuff = scala.collection.mutable.ArrayBuffer.empty[Employee]

  def addVehicle(vIn:Vehicle) =
  {
    for(x <- 0 to vIn.pBuff.size - 1)
    {
      val r = scala.util.Random
      r.nextInt(2) match
      {
        case 0 => vIn.pBuff(x).isBroken = false
        case 1 => vIn.pBuff(x).isBroken = true
      }

    }

    // Cost to fix
    vBuff += vIn
    vBuff(vBuff.size - 1).costFix = calcBill(vBuff(vBuff.size - 1).reg)

    // Time taken
    vBuff(vBuff.size - 1).timeTaken = {
      var totalTime:Double = 0.0
      for(y <- 0 to vBuff(vBuff.size - 1).pBuff.size - 1)
        {
          vBuff(vBuff.size - 1).pBuff(y).isBroken == true match
          {
            case true => totalTime += vBuff(vBuff.size - 1).pBuff(y).timeTaken
            case false =>
          }

        }
      totalTime
    }

    // Queue Check
    {
      vBuff(vBuff.size - 1).queueCheck = {
        vBuff(vBuff.size - 1).timeTaken * numBrokenParts(vBuff(vBuff.size - 1).reg)
      }
    }

  }

  def addEmployee(eIn:Employee) =
  {
    eBuff += eIn
  }

  def removeVehicleByID(vID:String) =
  {
    var x:Int = 0
    var y:Int = vBuff.size - 1

    def theRemove(vID:String, theX:Int, theY:Int) {

      var x = theX
      var y = theY

      x <= y match {
        case true => vBuff(x).getReg() == vID match {
          case true =>
            vBuff.remove(x)
            y -= 1
            theRemove(vID, x, y)
          case false =>
            x += 1
            theRemove(vID, x, y)
        }
        case false =>

      }
    }
    theRemove(vID, x, y)
  }

  def removeVehicleByType(vType:String) =
  {
    var x:Int = 0
    var y:Int = vBuff.size - 1

    def theRemove(vType:String, theX:Int, theY:Int) {

      var x = theX
      var y = theY

      x <= y match {
        case true => vBuff(x).getClass.toString.substring(6) == vType match {
          case true =>
            vBuff.remove(x)
            y -= 1
            theRemove(vType, x, y)
          case false =>
            x += 1
            theRemove(vType, x, y)
        }
        case false =>

      }
    }
    theRemove(vType, x, y)
  }

  ////////// VEHICLE FIX FUTURES GOES HERE //////////
  def vFix(index:Int):Unit =
  {
    // Copies index (current vehicle) to a new variable so it can be incremented.
      var theIndex = index

    // Check if index equals the size of the garage's vehicle list.
      theIndex == vBuff.size match
      {
        case true => // If true, you've reached the end of the vehicle list.
        case false => // If false, start/continue the loop.

          /* Causes the employee availability check to loop through all employees
             repeatedly until the switch value is changed from 0 to something else. */
          var availableSwitch = 0
          while(availableSwitch == 0) {

            /* If an available employee is matched with a vehicle, 'theval' will become false.
               If 'theval' is false, it will not bother checking the rest of the employees as
               a match has been found, and will effectively skip to the end of the loop. */
            var theval:Boolean = true

            /* Loop through all employees (this loop is repeated indefinitely while 'availableswitch'
               equals 0, i.e. no employees are available). */
            for (x <- 0 to eBuff.size - 1
                 if(theval) == true) {

              // Checks if the current employee is available.
              eBuff(x).isAvailable == true match {
                case true => // If available:

                  // Set current employee availability to false.
                  eBuff(x).isAvailable = false

                  // Add the current vehicle to the employee's vehicle list.
                  eBuff(x).addVehicle(vBuff(index))

                  // Print out which employee is handling the current vehicle and the time the work started and ended.
                  println("Employee " + eBuff(x).firstName + " " + eBuff(x).lastName + " is handling Vehicle " + vBuff(index).reg)
                  println(
                    "Time Started: "
                    + (f"${
                        eBuff(x).splitBuff.size == 1 match {
                          case true => 0.0
                          case false =>
                            eBuff(x).splitBuff.size == 2 match {
                              case true => eBuff(x).splitBuff(0).timeTaken
                              case false =>
                            var outTime: Double = 0.0
                            for (a <- 0 to eBuff.size - 2) {
                              outTime += eBuff(x).splitBuff(a).timeTaken
                            }
                            outTime
                          }
                        }
                      }%.2f")
                    + " hours.\nTime Finished: " + (f"${
                      eBuff(x).splitBuff.size == 1 match {
                        case true => eBuff(x).splitBuff(0).timeTaken
                        case false =>
                          var outTimeEnd:Double = 0.0
                          for (a <- 0 to eBuff(x).splitBuff.size - 1)
                          {
                            outTimeEnd += eBuff(x).splitBuff(a).timeTaken
                          }
                          outTimeEnd
                      }
                    }%.2f" + " hours.")
                  )

                  // Print the cost of fixing the current vehicle.
                  println(vBuff(index).costFix + "\n")

                  // Call the function to make the employee work on a vehicle for a specific time.
                  doTask(x)

                  // Set 'theval' to false so the rest of the employees are skipped.
                  theval = false

                  /* The availability switch will change from 0 to 1 to prevent the entire employee
                     list check running again. */
                  availableSwitch += 1

                  //

                case false => // If the employee isn't available, skip to the next one.
              }
            }

          }

          // Calls the function again with the index + 1 (the index of the next Vehicle in the garage's vehicle list.)
          vFix(index + 1)
      }

  }

  // Defines the sleep function.
  def sleep(time:Long){Thread.sleep(time)}

  // Gets the time taken for a specific employee's most recently added Vehicle to be repaired.
  // The function simulates the time taken before the employee finishes this task and becomes available again.
  def doTask(theEmp:Int): Unit =
  {
    val function = Future {
      sleep(eBuff(theEmp).splitBuff.last.timeTaken.toLong)
      eBuff(theEmp).isAvailable = true

    }
  }

  // Calculates the total cost of repair for one Vehicle.
  def calcBill(vID:String): Double =
  {
    var theCost:Double = 0.0
    for(x <- 0 to this.vBuff.size - 1)
      {
        vID.equals(vBuff(x).getReg()) match
        {
          case true =>

              vBuff(x).pBuff.size > 0 match
              {
                case true =>
                  for (y <- 0 to vBuff(x).pBuff.size - 1) {
                    vBuff(x).pBuff(y).isBroken == true match
                    {
                      case true => theCost += vBuff(x).pBuff(y).pCost
                      case false =>
                    }
                  }

                case false => theCost += 0.0
                case _ =>
              }

            vBuff(x).getClass.toString.substring(6) match
            {
             case "Car" => theCost += 100.0
             case "Bike" => theCost += 65.0
             case _ =>
            }
            case false =>
        }

      }
    theCost
  }

  def numBrokenParts(vID:String): Int = {

    var totalParts:Int = 0
    for(x <- 0 to this.vBuff.size - 1) {
      vID.equals(vBuff(x).getReg()) match {
        case true =>

          vBuff(x).pBuff.size > 0 match {
            case true =>
              for (y <- 0 to vBuff(x).pBuff.size - 1) {

                vBuff(x).pBuff(y).isBroken == true match
                {
                  case true =>
                    totalParts += 1
                  case false =>
                }
              }

            case false =>
            case _ =>
          }
        case false =>
      }
    }
    totalParts
  }

  def gOpen() =
  {
    isOpen = true

    vBuff = vBuff.sortWith(_.queueCheck > _.queueCheck)


    vFix(0)

    println("Total earnings for the day: £" + (f"${
        var theTotal:Double = 0.0
        for(x <- 0 to eBuff.size - 1)
          {
            for(y <- 0 to eBuff(x).splitBuff.size - 1)
            {
              theTotal += eBuff(x).splitBuff(y).costFix
            }
          }
      theTotal
      }%.2f")
    )

  }

  def gClose() =
  {
    isOpen = false
  }

  def timeTakenAll(): Double =
  {
    var totalTime:Double = 0.0
    for(x <- 0 to vBuff.length - 1)
      {
        totalTime +=vBuff(x).timeTaken
      }
    totalTime
  }

  override def toString: String =
  {
    var str : String = ""

    str += "\n--- Vehicles ---\n\n"

    vBuff.size match {
      case 0 =>
      case _ =>

        var carCount = 0
        var bikeCount = 0

        for (x <- 0 to vBuff.size - 1) {
          var theType = ""
          vBuff(x).getClass.toString.substring(6) match
          {
            case "Car" =>
              carCount += 1
              str += ("Car " + carCount + ":\n")

            case "Bike" =>
              bikeCount += 1
              str += ("Bike " + bikeCount + ":\n")

            case _ =>
          }

          var theFix = ""
          vBuff(x).isFixed match {
            case true => theFix = "Fixed"
            case false => theFix = "Queued for fix"
          }

          str +=
            (   "Reg. No.: " + vBuff(x).reg + "\n"
              + "Brand: " + vBuff(x).brand + "\n"
              + "Make: " + vBuff(x).make + "\n"
              + "Colour: " + vBuff(x).colour + "\n"
              + "Status: " + theFix + "\n"
              )

          vBuff(x).getClass.toString.substring(6) match
          {
            case "Car" =>
              var isAuto = ""
              vBuff(x).asInstanceOf[Car].automatic match {
                case true => isAuto = "Automatic"
                case false => isAuto = "Manual"
              }
              str +=
                  (
                    "Number of Doors: " + vBuff(x).asInstanceOf[Car].numDoors + "\n"
                  + "Transmission: " + isAuto + "\n"
                  )
            case "Bike" =>

              str +=
                (
                  "Number of Seats: " + vBuff(x).asInstanceOf[Bike].numSeats + "\n"
                  )

            case _ =>

          }
          str += "Parts:\n"
          vBuff(x).pBuff.size match
          {
            case 0 => str += "- None"
            case _ =>

          for(y <- 0 to vBuff(x).pBuff.size - 1)
            {
              str+= "- " + vBuff(x).pBuff(y).pName + " | Cost: £" +
                (f"${vBuff(x).pBuff(y).pCost}%.2f") +
                {
                  vBuff(x).pBuff(y).isBroken match
                  {
                    case true => " | Status: Broken\n"
                    case false => " |  Status: Working\n"
                  }
                }
            }
          }
          str += "\n"
        }
        str += "\n"
    }

    str += "--- Employees ---\n\n"

    eBuff.size match {
      case 0 =>
      case _ =>

        for (y <- 0 to eBuff.size - 1) {
          var theManager = ""
          eBuff(y).isManager match {
            case true => theManager = "Manager"
            case false => theManager = "Subordinate"
          }

          str +=
            (
                "Employee " + (y + 1) + ":\n"
                  + "Name: " + eBuff(y).firstName + " " + eBuff(y).lastName + "\n"
                  + "D.O.B.: " + eBuff(y).DOB + "\n"
                  + "Employee ID: " + eBuff(y).employeeID + "\n"
                  + "Employee Level: " + theManager + "\n\n"

            )
        }
    }

    var theOpen = ""
    isOpen match
    {
      case true => theOpen = "--- The garage is open. ---\n\n"
      case false =>"--- The garage is closed. ---\n\n"
    }
    str += theOpen

    str
  }

}
