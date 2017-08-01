/**
  * Created by Administrator on 12/06/2017.
  */
class Customer(firstName:String, lastName:String, DOB:String, customerID:String, address:String)
  extends Person(firstName, lastName, DOB)
{

  override def toString: String = "%s %s %s %s %s"
    .format(
      firstName,
      lastName,
      DOB,
      customerID,
      address
    )
  
}
