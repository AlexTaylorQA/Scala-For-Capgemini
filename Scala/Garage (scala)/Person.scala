/**
  * Created by Administrator on 12/06/2017.
  */
abstract class Person(firstName:String, lastName:String, DOB:String)
{

  override def toString: String = "%s %s %s"
    .format(
      firstName,
      lastName,
      DOB
    )

}
