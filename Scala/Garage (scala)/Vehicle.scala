/**
  * Created by Administrator on 12/06/2017.
  */
abstract class Vehicle(var reg:String, var brand:String, var make:String, var colour:String, var isFixed:Boolean, var costFix:Double, var timeTaken: Double, var queueCheck:Double)
{
  var pBuff = scala.collection.mutable.ArrayBuffer.empty[Part]

  def checkFix():String = {
    var theFix: String =
      if (isFixed == true) {
        "Fixed"
      }
      else {
        "Not yet fixed"
      }

    theFix
  }

  def getReg() =
  {
    this.reg
  }

  def setFixed() =
  {
    this.isFixed = true
  }

  def addPart(inP:Part) =
  {
    pBuff += inP
    costFix += inP.pCost

  }

  override def toString: String = "%s %s %s %s %s %s %s"
    .format(
        reg,
        brand,
        make,
        colour,
        checkFix(),
        costFix,
        timeTaken

  )
}

