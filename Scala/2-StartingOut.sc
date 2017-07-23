// Expressions
2 + 15             // = 17
49 * 100           // = 4900
1892 - 1472        // = 420
5f / 2f            // = 2.5
(50 * 100) - 4999  // = 1
50 * 100 - 4999    // = 1
50 * (100 - 4999)  // = -244950

// True and false checks
true && false      // = false
true && true       // = true
false || true      // = true
!false             // = true
!(true && true)    // = false
5 == 5             // = true
1 == 0             // = false
5 != 5             // = false
5 != 4             // = true
"hello" == "hello" // = true
5 + "llama"        // = "5llama"
5 == true          // = false

// Successor function
val succ = (x:Int) => x+1
succ(8)

// Min and Max functions
math.min(9, 10)    // = 9
math.min(3.4, 3.2) // = 3.2
math.max(100, 101) // = 101

// Sum with successor, min and max
succ(9 + math.max(5, 4) + 1)      // = 16
(succ(9)) + (math.max(5, 4)) + 1  // = 16

// First function
def doubleMe (x:Float):Float = {x + x}
doubleMe(9).asInstanceOf[Int]   // = 18
doubleMe(8.3f)

// Second function
def doubleUs (x:Float, y:Float):Float = {x*2 + y*2}
doubleUs(2.3f, 34.2f)  // = 73.0
(doubleUs(28, 88) + doubleMe(123)).asInstanceOf[Int]  // = 478

// Third function
def doubleUs2 (x:Float, y:Float):Float = {doubleMe(x) + doubleMe(y)}
doubleUs2(9, 3)   // = 24.0

// Fourth function
def doubleSmallNumber(x:Int):Int =
{
  x > 100 match{
    case true => x
    case false => x * 2
  }
}

def doubleSmallNumberPlusOne(x:Int):Int =
{
  (x > 100 match{
    case true => x
    case false => x * 2
  }) + 1
}

doubleSmallNumber(5)          // = 10
doubleSmallNumberPlusOne(5)   // = 11

// Define a string
val theString = "This is a string."

// Lists
val lostNumbers:List[Int] = List(4,8,15,16,23,42)

List(1,2,3,4) ++ List(9,10,11,12) // = List(1,2,3,4,9,10,11,12)

"hello" ++ " " ++ "world" // = "hello world"

"A" + " SMALL CAT"

"A" +: " SMALL CAT".toCharArray

val theListA = ("Steve Buscemi".toCharArray)
theListA(6) // = 'B'

val theListB = List(9.4,33.2,96.2,11.2,23.25)
theListB(1) // = 33.2

val theListC = List(List(1,2,3,4),List(5,3,3,3),List(1,2,2,3,4),List(1,2,3))
theListC ++ List(List(1,1,1,1))
List(List(6,6,6)) +: theListC
theListC(2)

List(5,4,3,2,1).head // = 5

List(5,4,3,2,1).tail // = List(4,3,2,1)

List(5,4,3,2,1).last // = 1

List(5,4,3,2,1).init // = List(5,4,3,2)

//List().head
// = NoSuchElementException: etc...
// Cannot run or nothing after it will run in worksheet

List(5,4,3,2,1).length // = 5

List(1,2,3).isEmpty   // = false
List().isEmpty        // = true

List(5,4,3,2,1).reverse  // = List(1,2,3,4,5)

List(5,4,3,2,1).take(3)  // = List(5,4,3)
List(3,9,3).take(1)      // = List(3)
List(1,2).take(5)        // = List(1,2)
List(6,6,6).take(0)      // = List()

List(8,4,2,1,5,6).drop(3)  // = List(1,5,6)
List(1,2,3,4).drop(0)      // = List(1,2,3,4)
List(1,2,3,4).drop(100)    // = List()

List(8,4,2,1,5,6).min  // = 1

List(1,9,2,3,4).max    // = 9

List(5,2,1,6,3,2,5,7).sum  // = 31

List(6,2,1,2).product   // = 24
List(1,2,5,6,7,9,2,0).product  // = 0

List(3,4,5,6).contains(4)   // = true
List(3,4,5,6).contains(10)  // = false

// Texas Ranges
List(1 to 100:_*)      // = 1 2 3 4 ... 99 100
List('a' to 'z':_*)    // = a b c ... x y z
List('K' to 'Z':_*)    // = K L M ... X Y Z
List(2 to 20 by 2:_*)  // = 2 4 6 ... 18 20
List(3 to 20 by 3:_*)  // = 3 6 9 ... 15 18
List(0.1 to 1.0 by 0.2:_*) // = List(0.1, 0.30000000000000004, 0.5, 0.7, 0.8999999999999999)
                           // The above result is mathematically incorrect, but is a quirk of Scala.

// Infinite ranges
Stream.continually(List(1, 2, 3).toStream).flatten.take(10).toList
Stream.continually(List(5).toStream).flatten.take(12).toList

(for(i <- 1 to 10)yield i * 2).toList

(for(j <- 1 to 10)yield{j * 2 >= 12 match{case true => Some(j * 2) case _ => None }}).toList.flatten

(for(k <- 50 to 100)yield{k % 7 == 3 match{case true => Some(k) case _ => None }}).toList.flatten

// Turn all odd numbers less than 10 into "Boom", all numbers greater than 10 into "Bang", dump the rest.
def boomBangs(x:Int, xs:Int):List[String] =
{
  (for(y <- x to xs)yield{y % 2 != 0 match{case true => y < 10 match{case true => Some("BOOM") case false => Some("BANG")}case false => None}}).toList.flatten
}

boomBangs(7, 13)

// Excluding numbers from the x to y loop
(for(l <- 10 to 20)yield{ (l != 13 && l != 15 && l != 19) match {case false => None case true => Some(l)}}).toList.flatten

// Get products of every combination of two lists
for(m <- List(2,5,10); n <- List(8,10,11))yield(m*n)

// Get products of every combination of two lists where x * y > 50
(for(m <- List(2,5,10); n <- List(8,10,11))yield(m*n > 50 match{case true => Some(m*n) case false => None})).toList.flatten

// Make a list of all word combinations in two lists.
val nouns = List("hobo","frog","pope")
val adjectives = List("lazy","grouchy","scheming")
for(o <- adjectives; p <- nouns)yield(o + " " + p)

// Make your own 'length' function.
def theLength(inList:List[Any]):Int = {(for(q <- inList)yield(1)).sum}
theLength(List("a", "b", "c"))          // = 3
theLength(List(1, 78, 1234, 9548902))   // = 4

// Remove non uppercase characters from strings
def removeNonUppercase(inString:String):String =
{
  (for(r <- inString) yield (if((for(s <- 'A' to 'Z')yield s).contains(r)){Some(r)}else{None})).toList.flatten.mkString
}

removeNonUppercase("Hahaha! Ahahaha!")   // = "HA"
removeNonUppercase("IdontLIKEFROGS")     // = "ILIKEFROGS"

// Remove all odd numbers.
val t = List(
  List(1,3,5,2,3,1,2,4,5),
  List(1,2,3,4,5,6,7,8,9),
  List(1,2,4,2,1,6,3,1,3,2,3,6)
)

for(u <- t)yield(for(v <- u) yield(v % 2 == 0 match{case true => Some(v) case false => None})).flatten

// Tuples

(8,11)._1           // = 8
("Wow", false)._1   // "Wow"
(8,11)._2           // = 11
("Wow", false)._2   // false

List(1,2,3,4,5).zip(List(5,5,5,5,5))  // = (1,5), (2,5), etc...
(1 to 5).toList.zip(List("one", "two", "three", "four", "five"))
List(5,3,2,6,2,7,2,5,4,6,6).zip(List("im", "a", "turtle"))   // = only the first three

val theListD = List("apple", "orange", "cherry", "mango")
List(1 to theListD.length:_*).zip(theListD)

// Produces all triangles with sides up to 10 in length
val triangles = (for(a1 <- 1 to 10; b1 <- 1 to 10; c1 <- 1 to 10)yield (a1,b1,c1))

// Produces all right triangles with sides up to 10 in length
val rightTriangles = (for(a1 <- 1 to 10; b1 <- 1 to 10; c1 <- 1 to 10)yield{((math.pow(a1, 2)) + math.pow(b1, 2) == math.pow(c1, 2) match{case true => Some(a1,b1,c1) case false => None})}).toList.flatten

// Produces all right triangles with sides up to 10 in length where the perimeter equals 24
val perimeterRightTriangles = (for(a1 <- 1 to 10; b1 <- 1 to 10; c1 <- 1 to 10)yield{(((math.pow(a1, 2)) + math.pow(b1, 2) == math.pow(c1, 2)) && (a1 + b1 + c1 == 24) match{case true => Some(a1,b1,c1) case false => None})}).toList.flatten