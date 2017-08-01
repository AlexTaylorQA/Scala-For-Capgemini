/**
  * Created by Administrator on 12/06/2017.
  */
class Employee(var firstName:String, var lastName:String, var DOB:String, var employeeID:String, var isManager:Boolean, var isAvailable:Boolean)
  extends Person(firstName, lastName, DOB)
{
  var splitBuff = scala.collection.mutable.ArrayBuffer.empty[Vehicle]

  var theManager: String = (
    if(isManager == true) {
      "Manager"
    }
    else
    {
      "Subordinate"
    }
    )

  def addVehicle(vIn:Vehicle) = {
    splitBuff += vIn
  }

  override def toString: String = "%s %s %s %s %s"
    .format(
      firstName,
      lastName,
      DOB,
      employeeID,
      isManager
    )
}
