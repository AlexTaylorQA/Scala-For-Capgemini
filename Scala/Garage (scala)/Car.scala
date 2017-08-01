/**
  * Created by Administrator on 12/06/2017.
  */
class Car(reg:String, brand:String, make:String, colour:String, isFixed:Boolean, costFix:Double, timeTaken:Double, queueCheck:Double, var numDoors:Int, var automatic:Boolean)
  extends Vehicle(reg, brand, make, colour, isFixed, costFix, timeTaken, queueCheck)
{
  var theAuto: String = (
    if(automatic == true) {
      "Automatic"
    }
    else
    {
      "Manual"
    }
    )

  def getNumDoors(): Int = {
    numDoors
  }

  def getAutomatic(): Boolean = {
    automatic
  }

  override def toString: String = "%s %s %s %s %s %s %s %s %s"
    .format(
      reg,
      brand,
      make,
      colour,
      this.checkFix(),
      costFix.toString,
      timeTaken.toString,
      numDoors.toString(),
      this.theAuto
    )
}
