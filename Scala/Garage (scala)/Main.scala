/**
  * Created by Administrator on 12/06/2017.
  */
object Main extends App
{
  val g = new Garage(true)

  val a = new Car("SW08TNO", "Vauxhall", "Agila", "Blue", false, 0.0, 0.0, 0.0, 5, true)
  val b = new Car("AB238ZL", "Lamborghini", "Murcielago", "Orange", false, 0.0, 0.0, 0.0, 2, false)
  val c = new Bike("BK01SJV", "Harley-Davidson", "Sportster", "Red", false, 0.0, 0.0, 0.0, 1)
  val d = new Bike("VP07PQR", "Piaggio", "Vespa", "Yellow", false, 0.0, 0.0, 0.0, 2)

  val ap1 = new Part("Tyres", 100.0, false, 1.5)
  val ap2 = new Part("Fan Belt", 50.0, false, 2.1)
  val ap3 = new Part("Carburettor", 100.0, false, 3.5)
  val ap4 = new Part("Battery", 50.0, false, 2.3)
  val ap5 = new Part("Windscreen Wipers", 100.0, false, 0.5)
  val ap6 = new Part("Headlights", 50.0, false, 3.2)
  val ap7 = new Part("Brakes", 100.0, false, 6.7)
  val ap8 = new Part("Exhaust", 50.0, false, 4.3)
  val ap9 = new Part("Air Intake", 100.0, false, 6.9)
  val ap10 = new Part("Starter Motor", 50.0, false, 8.4)

  a.addPart(ap1)
  a.addPart(ap2)
  a.addPart(ap3)
  a.addPart(ap4)
  a.addPart(ap5)
  a.addPart(ap6)
  a.addPart(ap7)
  a.addPart(ap8)
  a.addPart(ap9)
  a.addPart(ap10)

  val bp1 = new Part("Tyres", 100.0, false, 0.1)
  val bp2 = new Part("Fan Belt", 54.22, false, 0.1)
  val bp3 = new Part("Carburettor", 105.25, false, 0.1)
  val bp4 = new Part("Battery", 77.0, false, 0.1)
  val bp5 = new Part("Windscreen Wipers", 35.0, false, 0.1)
  val bp6 = new Part("Headlights", 83.4, false, 0.1)
  val bp7 = new Part("Brakes", 62.5, false, 0.1)
  val bp8 = new Part("Exhaust", 45.0, false, 0.1)
  val bp9 = new Part("Air Intake", 60.0, false, 0.1)
  val bp10 = new Part("Starter Motor", 150.0, false, 0.1)

  b.addPart(bp1)
  b.addPart(bp2)
  b.addPart(bp3)
  b.addPart(bp4)
  b.addPart(bp5)
  b.addPart(bp6)
  b.addPart(bp7)
  b.addPart(bp8)
  b.addPart(bp9)
  b.addPart(bp10)

  val cp1 = new Part("Tyres", 100.0, false, 1.5)
  val cp2 = new Part("Fan Belt", 54.22, false, 2.1)
  val cp3 = new Part("Carburettor", 105.25, false, 3.5)
  val cp4 = new Part("Battery", 77.0, false, 2.3)
  val cp5 = new Part("Windscreen Wipers", 35.0, false, 0.5)
  val cp6 = new Part("Headlights", 83.4, false, 3.2)
  val cp7 = new Part("Brakes", 62.5, false, 6.7)
  val cp8 = new Part("Exhaust", 45.0, false, 4.3)
  val cp9 = new Part("Air Intake", 60.0, false, 6.9)
  val cp10 = new Part("Starter Motor", 150.0, false, 8.4)

  c.addPart(cp1)
  c.addPart(cp2)
  c.addPart(cp3)
  c.addPart(cp4)
  c.addPart(cp5)
  c.addPart(cp6)
  c.addPart(cp7)
  c.addPart(cp8)
  c.addPart(cp9)
  c.addPart(cp10)

  val dp1 = new Part("Tyres", 100.0, false, 1.5)
  val dp2 = new Part("Fan Belt", 54.22, false, 2.1)
  val dp3 = new Part("Carburettor", 105.25, false, 3.5)
  val dp4 = new Part("Battery", 77.0, false, 2.3)
  val dp5 = new Part("Windscreen Wipers", 35.0, false, 0.5)
  val dp6 = new Part("Headlights", 83.4, false, 3.2)
  val dp7 = new Part("Brakes", 62.5, false, 6.7)
  val dp8 = new Part("Exhaust", 45.0, false, 4.3)
  val dp9 = new Part("Air Intake", 60.0, false, 6.9)
  val dp10 = new Part("Starter Motor", 150.0, false, 8.4)

  d.addPart(dp1)
  d.addPart(dp2)
  d.addPart(dp3)
  d.addPart(dp4)
  d.addPart(dp5)
  d.addPart(dp6)
  d.addPart(dp7)
  d.addPart(dp8)
  d.addPart(dp9)
  d.addPart(dp10)

  g.addVehicle(a)
  g.addVehicle(b)
  g.addVehicle(c)
  g.addVehicle(d)

  // FINAL OUTPUT

  println("Time taken to fix all vehicles: " + (f"${g.timeTakenAll}%.2f") + " hours.\n")

  // println("Number of cars in the garage: " +  g.vBuff.size)

  val e1 = new Employee("John", "Jackson", "1/1/2000", "EM-0000", false, true)
  val e2 = new Employee("Jack", "Johnson", "31/12/1999", "EM-0001", false, true)
  val e3 = new Employee("Max", "LeManager", "20/4/1984", "EM-0002", true, true)

  g.addEmployee(e1)
  g.addEmployee(e2)
  g.addEmployee(e3)

  g.gOpen

  /*

  println("Number of employees in the company: " + g.eBuff.size)

  println(g.toString)

  g.gOpen()

  println(g.toString)


  g.removeVehicleByID("a")
  println("Number of cars in garage: " +  g.vBuff.size)
  g.removeVehicleByType("Car")
  println("Number of cars in garage: " +  g.vBuff.size)

  g.gOpen()
  println(g.isOpen)
  g.gClose()
  println(g.isOpen)
  g.gOpen()
  println(g.isOpen)

  */

}
