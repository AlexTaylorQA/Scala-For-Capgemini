// Pattern Matching
def lucky(a:Int):String = {
  a match {
    case 7 => "LUCKY NUMBER SEVEN!"  // Returns message if input is 7.
    case _ => "Sorry, you're out of luck, pal!"  // Returns message if input is anything else.
  }
}

// Returns the appropriate number as a string if it is between 1 and 5.
def sayMe(a:Int):String = {
  a match{
    case 1 => "One!"
    case 2 => "Two!"
    case 3 => "Three!"
    case 4 => "Four!"
    case 5 => "Five!"
    case _ => "Not between 1 and 5" // If the number isn't between 1 and 5, it says so.
  }
}

sayMe(4)  // = "Four!"

// Returns the factorial of the inputted number using recursion.
def factorial(a:Int):Int = {
  a match
  {
    case 0 => 1  // Treats 'factorial(0)' as 1 so the number remains unchanged, and stops calculating.
    case _ => a * factorial(a - 1) // e.g. 4 * factorial(3) == 4 * 3 * factorial(2) == 4 * 3 * 2 * factorial(1), etc.
  }
}

factorial(4)  // = 24

// Inputting a char returns a full name beginning with that char.
def charName(theChar:Char):String = {
  theChar match{
    case 'a' => "Albert"
    case 'b' => "Broseph"
    case 'c' => "Cecil"
    case _ => "Sorry, we don't have a name for that char."
  }
}

charName('a')  // = "Albert"

// For each tuple in a list, yield the sum of its two values. Output as a list of these sums.
val listA = List((1,3), (4,3), (2,4), (5,3), (5,6), (3,1))
for(x <- listA)yield{x._1 + x._2}
// = List(4, 7, 6, 8, 11, 4)


// Returns the first item in an inputted list. If the list is empty, it outputs a warning.
def head(theList:List[Any]):Any = {
  theList.isEmpty match {
    case true => "Can't call head on an empty list, dummy!"
    case false => theList(0)
  }
}

head(List())  // = "Can't call head on an empty list, dummy!"
head(List(4,5,6))  // = 4
head("Hello".toList)  // = "H"

// Checks if an inputted list is empty.
def tell(theList:List[Any]):String = {
  theList match{
    case Nil  => "The list is empty."
    case x::xs => "The list has at least one value."
    case _ => "Something broke."
  }
}
tell(List())  // = "The list is empty."
tell(List(1,2,3)) // = "The list has at least one value."

def tellLength(theList:List[Any]):String = {
  theList match{
    case Nil  => "The list is empty."
    case x::Nil => "The list has one entry: " + x + "."
    case x::y::Nil => "The list has two entries: " + x + " and " + y + "."
    case x::y::_ => "The list has many values. The first two are: " + x + " and " + y + "."
    case _ => "Something broke."
  }
}

// Checks an inputted list and tells you if it has none, one, two or more than two values, and what those values are.
tellLength(List())  // = "The list is empty."
tellLength(List(1))  // = "The list has one entry: 1."
tellLength(List(1,2))  // = "The list has two entries: 1 and 2."
tellLength(List(1,2,3,4)) // = "The list has many values. The first two are: 1 and 2."

// Gets the length of an inputted list.
def getLength(theList:List[Any]):Int = {
  theList match {
    case Nil => 0
    case _::xs => 1 + getLength(xs)
  }
}

getLength(List(0,3,2,6,4,1,5))  // = 7

// Gets the sum of an inputted list's values.
def getSum(theList:List[Int]):Int = {
  theList match {
    case Nil => 0
    case (x::xs) => x + getSum(xs)
  }
}

getSum(List(1,2,3))  // = 6

// Gets the first letter of an inputted string.
def capital(inString:String):String = {
  inString.toList match {
    case Nil =>  "Empty string, whoops!"
    case (x::xs) => "The first letter of " + inString + " is " + x + "."
  }
}

capital("Dracula")  // = "The first letter of Dracula is D."

// Outputs a message depending on the inputted BMI.
def checkBMI(BMI:Float):String = {
  BMI match {
    case x if x <= 18.5 => "You are underweight."
    case x if x <= 25.0 => "You are of normal weight."
    case x if x <= 30.0 => "You are a little overweight."
    case _ => "You are dangerously overweight."
  }
}

math.pow(1.9f, 2)

checkBMI(21)  // = "You are of normal weight."

// Calculates BMI based on an inputted weight and height, then outputs the appropriate message.
def checkBMIcalc(height:Float, weight:Float):String = {
  (weight / (math.pow(height, 2))) match {
    case x if x <= 18.5 => "You are underweight."
    case x if x <= 25.0 => "You are of normal weight."
    case x if x <= 30.0 => "You are a little overweight."
    case _ => "You are dangerously overweight."
  }
}

checkBMIcalc((1.9).toFloat, (85).toFloat)  // =  You are of normal weight.

// Calculates if the first number is greater than, less than or equal to the second number.
def myCompare(a:Int, b:Int):String = {
  (a, b) match {
    case x if x._1 > x._2 => "GT"
    case x if x._1 == x._2 => "EQ"
    case _ => "LT"
  }
}

myCompare(3,2)  // = "GT"
myCompare(3,3)  // = "EQ"
myCompare(2,3)  // = "LT"

def initials(fName:String, lName:String):String = {
  (fName, lName) match {
    case x => x._1.head + ". " + x._2.head + "."
  }
}

initials("John", "Smith")

// Calculates a cylinder's surface area.
def cylinder(radius:Float, height:Float):Float = {
  val theArea = {
    val sideArea = 2 * math.Pi * radius * height
    val topArea = math.Pi * math.pow(radius, 2)
    (sideArea + 2 * topArea).toFloat
  }
  theArea
}

cylinder(5.0f, 10.0f)  // = 471.2389


// Use of expressions inside declarations.
val thisList = List({5 > 3 match{case true => "Woo" case false => "Bar"}}, {'a' > 'b' match{case true => "Foo" case false => "Bar"}})
// = List("Woo", "Bar")

val thisNumA = 4 * (10 > 5 match{case true => 10 case false => 0}) + 2
// = 42

val thisNumB = 4 * ({val a = 9; a + 1}) + 2
// = 42

// Find the squares of a list of numbers.
def square(numList:List[Int]):List[Int] = {
  for(x <- numList)yield(math.pow(x, 2).toInt)
}

square(List(5,3,2))  // = List(25,9,4)

// Takes in numbers and performs a calculation on them.
def doCalc(theNums:(Int, Int, Int)):Int = {
  (theNums._1 + theNums._2 + theNums._3) * 100
}

doCalc((1,2,3))  // = 600

