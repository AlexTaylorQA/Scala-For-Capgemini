/**
  * Created by Administrator on 12/06/2017.
  */
class Bike(reg:String, brand:String, make:String, colour:String, isFixed:Boolean, costFix:Double, queueCheck:Double, timeTaken:Double, var numSeats:Int)
  extends Vehicle(reg, brand, make, colour, isFixed, costFix, timeTaken, queueCheck) {

  override def toString: String = "%s %s %s %s %s %s %s %s"
    .format(
      reg,
      brand,
      make,
      colour,
      this.checkFix(),
      costFix.toString,
      timeTaken.toString,
      numSeats.toString()
    )
}
