'a'          // char
true         // boolean
"HELLO!"     // string
(true, 'a')  // (boolean, char)
4 == 5       // boolean == false

// Addition
def addThree(a:Int, b:Int, c:Int):Int = {a + b + c}
val addThreeOut:Int = addThree(1,2,3)

// Factorials
def factorial(numIn:Int):Int = {(for(d <- 1 to numIn)yield d).toList.product}
val factorialOut = factorial(10)  // = 3628800

// Circumference (Float)
def circumference(radius:Float):Float = {(2.0f * scala.math.Pi * radius).toFloat}
val circumferenceOut = circumference(4.0f)  // = 25.132742

// Circumference (Double)
def circumferenceD(radius:Double):Double = {(2.0 * scala.math.Pi * radius)}
val circumferenceDOut = circumferenceD(4.0)  // = 25.132741228718345

// Equality testing
5 == 5              // = true
5 != 5              // = false
'a' == 'a'          // = true
"Ho Ho" == "Ho Ho"  // = true
3.432 == 3.432      // = true
"Abrakadabra" < "Zebra"  // = true
"Abrakadabra".compareTo("Zebra") // negative number i.e. less than
5 >= 2              // = true
5.compareTo(2)      // positive number i.e. greater than
3.toString          // "3"
5.334.toString      // "5.344"
true.toString       // "true"
"5".toInt
"5".toFloat
("5".toFloat) * 4
Int.MinValue
Int.MaxValue
