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
succ(8)  // = 9 (successor of 8, i.e. 8 + 1)

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
doubleMe(8.3f)   // = 16.6

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
val theString = "This is a string."   // = "This is a string"

// Lists
val lostNumbers:List[Int] = List(4,8,15,16,23,42)  // = List(4,8,15,16,23,42)

List(1,2,3,4) ++ List(9,10,11,12) // = List(1,2,3,4,9,10,11,12)

"hello" ++ " " ++ "world" // = "hello world"

"A" + " SMALL CAT"  // = "A SMALL CAT

"A" +: " SMALL CAT".toCharArray  // = Array(A,  , S, M, A, L, L,  , C, A, T)

val theListA = ("Steve Buscemi".toCharArray)
theListA(6) // = 'B'

val theListB = List(9.4,33.2,96.2,11.2,23.25)
theListB(1) // = 33.2

val theListC = List(List(1,2,3,4),List(5,3,3,3),List(1,2,2,3,4),List(1,2,3))
theListC ++ List(List(1,1,1,1))
// = List(List(1, 2, 3, 4), List(5, 3, 3, 3), List(1, 2, 2, 3, 4), List(1, 2, 3), List(1, 1, 1, 1))

List(List(6,6,6)) +: theListC
// = List(List(List(6, 6, 6)), List(1, 2, 3, 4), List(5, 3, 3, 3), List(1, 2, 2, 3, 4), List(1, 2, 3))

theListC(2)
// = List(1, 2, 2, 3, 4)

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
// = List(1, 2, 3, 1, 2, 3, 1, 2, 3, 1)

Stream.continually(List(5).toStream).flatten.take(12).toList
// = List(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5)

(for(i <- 1 to 10)yield i * 2).toList
// = List(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)

(for(j <- 1 to 10)yield{j * 2 >= 12 match{case true => Some(j * 2) case _ => None }}).toList.flatten
// = List(12, 14, 16, 18, 20)

(for(k <- 50 to 100)yield{k % 7 == 3 match{case true => Some(k) case _ => None }}).toList.flatten
// = List(52, 59, 66, 73, 80, 87, 94)

// Turn all odd numbers less than 10 into "Boom", all numbers greater than 10 into "Bang", dump the rest.
def boomBangs(x:Int, xs:Int):List[String] =
{
  (for(y <- x to xs)yield{y % 2 != 0 match{case true => y < 10 match{case true => Some("BOOM") case false => Some("BANG")}case false => None}}).toList.flatten
}

boomBangs(7, 13) // = List(BOOM, BOOM, BANG, BANG)


// Excluding numbers from the x to y loop
(for(l <- 10 to 20)yield{ (l != 13 && l != 15 && l != 19) match {case false => None case true => Some(l)}}).toList.flatten
// = List(10, 11, 12, 14, 16, 17, 18, 20)

// Get products of every combination of two lists
for(m <- List(2,5,10); n <- List(8,10,11))yield(m*n)
// = List(16, 20, 22, 40, 50, 55, 80, 100, 110)

// Get products of every combination of two lists where x * y > 50
(for(m <- List(2,5,10); n <- List(8,10,11))yield(m*n > 50 match{case true => Some(m*n) case false => None})).toList.flatten
// = List(55, 80, 100, 110)

// Make a list of all word combinations in two lists.
val nouns = List("hobo","frog","pope")
val adjectives = List("lazy","grouchy","scheming")
for(o <- adjectives; p <- nouns)yield(o + " " + p)
// = List(lazy hobo, lazy frog, lazy pope, grouchy hobo, grouchy frog, grouchy pope, scheming hobo, scheming frog, scheming pope)

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
// = List(List(2, 2, 4), List(2, 4, 6, 8), List(2, 4, 2, 6, 2, 6))


// Tuples

(8,11)._1           // = 8
("Wow", false)._1   // "Wow"
(8,11)._2           // = 11
("Wow", false)._2   // false

List(1,2,3,4,5).zip(List(5,5,5,5,5))  // = List((1,5), (2,5), (3,5), (4,5), (5,5))
(1 to 5).toList.zip(List("one", "two", "three", "four", "five")) // = List((1,one), (2,two), (3,three), (4,four), (5,five))
List(5,3,2,6,2,7,2,5,4,6,6).zip(List("im", "a", "turtle"))   // = List((5,im), (3,a), (2,turtle))

val theListD = List("apple", "orange", "cherry", "mango")
List(1 to theListD.length:_*).zip(theListD)  // = List((1,apple), (2,orange), (3,cherry), (4,mango))

// Produces all triangles with sides up to 10 in length
val triangles = (for(a1 <- 1 to 10; b1 <- 1 to 10; c1 <- 1 to 10)yield (a1,b1,c1))
// = Vector((1,1,1), (1,1,2), (1,1,3), (1,1,4), (1,1,5), (1,1,6), (1,1,7), (1,1,8), (1,1,9), (1,1,10), (1,2,1), (1,2,2), (1,2,3), (1,2,4), (1,2,5), (1,2,6), (1,2,7), (1,2,8), (1,2,9), (1,2,10), (1,3,1), (1,3,2), (1,3,3), (1,3,4), (1,3,5), (1,3,6), (1,3,7), (1,3,8), (1,3,9), (1,3,10), (1,4,1), (1,4,2), (1,4,3), (1,4,4), (1,4,5), (1,4,6), (1,4,7), (1,4,8), (1,4,9), (1,4,10), (1,5,1), (1,5,2), (1,5,3), (1,5,4), (1,5,5), (1,5,6), (1,5,7), (1,5,8), (1,5,9), (1,5,10), (1,6,1), (1,6,2), (1,6,3), (1,6,4), (1,6,5), (1,6,6), (1,6,7), (1,6,8), (1,6,9), (1,6,10), (1,7,1), (1,7,2), (1,7,3), (1,7,4), (1,7,5), (1,7,6), (1,7,7), (1,7,8), (1,7,9), (1,7,10), (1,8,1), (1,8,2), (1,8,3), (1,8,4), (1,8,5), (1,8,6), (1,8,7), (1,8,8), (1,8,9), (1,8,10), (1,9,1), (1,9,2), (1,9,3), (1,9,4), (1,9,5), (1,9,6), (1,9,7), (1,9,8), (1,9,9), (1,9,10), (1,10,1), (1,10,2), (1,10,3), (1,10,4), (1,10,5), (1,10,6), (1,10,7), (1,10,8), (1,10,9), (1,10,10), (2,1,1), (2,1,2), (2,1,3), (2,1,4), (2,1,5), (2,1,6), (2,1,7), (2,1,8), (2,1,9), (2,1,10), (2,2,1), (2,2,2), (2,2,3), (2,2,4), (2,2,5), (2,2,6), (2,2,7), (2,2,8), (2,2,9), (2,2,10), (2,3,1), (2,3,2), (2,3,3), (2,3,4), (2,3,5), (2,3,6), (2,3,7), (2,3,8), (2,3,9), (2,3,10), (2,4,1), (2,4,2), (2,4,3), (2,4,4), (2,4,5), (2,4,6), (2,4,7), (2,4,8), (2,4,9), (2,4,10), (2,5,1), (2,5,2), (2,5,3), (2,5,4), (2,5,5), (2,5,6), (2,5,7), (2,5,8), (2,5,9), (2,5,10), (2,6,1), (2,6,2), (2,6,3), (2,6,4), (2,6,5), (2,6,6), (2,6,7), (2,6,8), (2,6,9), (2,6,10), (2,7,1), (2,7,2), (2,7,3), (2,7,4), (2,7,5), (2,7,6), (2,7,7), (2,7,8), (2,7,9), (2,7,10), (2,8,1), (2,8,2), (2,8,3), (2,8,4), (2,8,5), (2,8,6), (2,8,7), (2,8,8), (2,8,9), (2,8,10), (2,9,1), (2,9,2), (2,9,3), (2,9,4), (2,9,5), (2,9,6), (2,9,7), (2,9,8), (2,9,9), (2,9,10), (2,10,1), (2,10,2), (2,10,3), (2,10,4), (2,10,5), (2,10,6), (2,10,7), (2,10,8), (2,10,9), (2,10,10), (3,1,1), (3,1,2), (3,1,3), (3,1,4), (3,1,5), (3,1,6), (3,1,7), (3,1,8), (3,1,9), (3,1,10), (3,2,1), (3,2,2), (3,2,3), (3,2,4), (3,2,5), (3,2,6), (3,2,7), (3,2,8), (3,2,9), (3,2,10), (3,3,1), (3,3,2), (3,3,3), (3,3,4), (3,3,5), (3,3,6), (3,3,7), (3,3,8), (3,3,9), (3,3,10), (3,4,1), (3,4,2), (3,4,3), (3,4,4), (3,4,5), (3,4,6), (3,4,7), (3,4,8), (3,4,9), (3,4,10), (3,5,1), (3,5,2), (3,5,3), (3,5,4), (3,5,5), (3,5,6), (3,5,7), (3,5,8), (3,5,9), (3,5,10), (3,6,1), (3,6,2), (3,6,3), (3,6,4), (3,6,5), (3,6,6), (3,6,7), (3,6,8), (3,6,9), (3,6,10), (3,7,1), (3,7,2), (3,7,3), (3,7,4), (3,7,5), (3,7,6), (3,7,7), (3,7,8), (3,7,9), (3,7,10), (3,8,1), (3,8,2), (3,8,3), (3,8,4), (3,8,5), (3,8,6), (3,8,7), (3,8,8), (3,8,9), (3,8,10), (3,9,1), (3,9,2), (3,9,3), (3,9,4), (3,9,5), (3,9,6), (3,9,7), (3,9,8), (3,9,9), (3,9,10), (3,10,1), (3,10,2), (3,10,3), (3,10,4), (3,10,5), (3,10,6), (3,10,7), (3,10,8), (3,10,9), (3,10,10), (4,1,1), (4,1,2), (4,1,3), (4,1,4), (4,1,5), (4,1,6), (4,1,7), (4,1,8), (4,1,9), (4,1,10), (4,2,1), (4,2,2), (4,2,3), (4,2,4), (4,2,5), (4,2,6), (4,2,7), (4,2,8), (4,2,9), (4,2,10), (4,3,1), (4,3,2), (4,3,3), (4,3,4), (4,3,5), (4,3,6), (4,3,7), (4,3,8), (4,3,9), (4,3,10), (4,4,1), (4,4,2), (4,4,3), (4,4,4), (4,4,5), (4,4,6), (4,4,7), (4,4,8), (4,4,9), (4,4,10), (4,5,1), (4,5,2), (4,5,3), (4,5,4), (4,5,5), (4,5,6), (4,5,7), (4,5,8), (4,5,9), (4,5,10), (4,6,1), (4,6,2), (4,6,3), (4,6,4), (4,6,5), (4,6,6), (4,6,7), (4,6,8), (4,6,9), (4,6,10), (4,7,1), (4,7,2), (4,7,3), (4,7,4), (4,7,5), (4,7,6), (4,7,7), (4,7,8), (4,7,9), (4,7,10), (4,8,1), (4,8,2), (4,8,3), (4,8,4), (4,8,5), (4,8,6), (4,8,7), (4,8,8), (4,8,9), (4,8,10), (4,9,1), (4,9,2), (4,9,3), (4,9,4), (4,9,5), (4,9,6), (4,9,7), (4,9,8), (4,9,9), (4,9,10), (4,10,1), (4,10,2), (4,10,3), (4,10,4), (4,10,5), (4,10,6), (4,10,7), (4,10,8), (4,10,9), (4,10,10), (5,1,1), (5,1,2), (5,1,3), (5,1,4), (5,1,5), (5,1,6), (5,1,7), (5,1,8), (5,1,9), (5,1,10), (5,2,1), (5,2,2), (5,2,3), (5,2,4), (5,2,5), (5,2,6), (5,2,7), (5,2,8), (5,2,9), (5,2,10), (5,3,1), (5,3,2), (5,3,3), (5,3,4), (5,3,5), (5,3,6), (5,3,7), (5,3,8), (5,3,9), (5,3,10), (5,4,1), (5,4,2), (5,4,3), (5,4,4), (5,4,5), (5,4,6), (5,4,7), (5,4,8), (5,4,9), (5,4,10), (5,5,1), (5,5,2), (5,5,3), (5,5,4), (5,5,5), (5,5,6), (5,5,7), (5,5,8), (5,5,9), (5,5,10), (5,6,1), (5,6,2), (5,6,3), (5,6,4), (5,6,5), (5,6,6), (5,6,7), (5,6,8), (5,6,9), (5,6,10), (5,7,1), (5,7,2), (5,7,3), (5,7,4), (5,7,5), (5,7,6), (5,7,7), (5,7,8), (5,7,9), (5,7,10), (5,8,1), (5,8,2), (5,8,3), (5,8,4), (5,8,5), (5,8,6), (5,8,7), (5,8,8), (5,8,9), (5,8,10), (5,9,1), (5,9,2), (5,9,3), (5,9,4), (5,9,5), (5,9,6), (5,9,7), (5,9,8), (5,9,9), (5,9,10), (5,10,1), (5,10,2), (5,10,3), (5,10,4), (5,10,5), (5,10,6), (5,10,7), (5,10,8), (5,10,9), (5,10,10), (6,1,1), (6,1,2), (6,1,3), (6,1,4), (6,1,5), (6,1,6), (6,1,7), (6,1,8), (6,1,9), (6,1,10), (6,2,1), (6,2,2), (6,2,3), (6,2,4), (6,2,5), (6,2,6), (6,2,7), (6,2,8), (6,2,9), (6,2,10), (6,3,1), (6,3,2), (6,3,3), (6,3,4), (6,3,5), (6,3,6), (6,3,7), (6,3,8), (6,3,9), (6,3,10), (6,4,1), (6,4,2), (6,4,3), (6,4,4), (6,4,5), (6,4,6), (6,4,7), (6,4,8), (6,4,9), (6,4,10), (6,5,1), (6,5,2), (6,5,3), (6,5,4), (6,5,5), (6,5,6), (6,5,7), (6,5,8), (6,5,9), (6,5,10), (6,6,1), (6,6,2), (6,6,3), (6,6,4), (6,6,5), (6,6,6), (6,6,7), (6,6,8), (6,6,9), (6,6,10), (6,7,1), (6,7,2), (6,7,3), (6,7,4), (6,7,5), (6,7,6), (6,7,7), (6,7,8), (6,7,9), (6,7,10), (6,8,1), (6,8,2), (6,8,3), (6,8,4), (6,8,5), (6,8,6), (6,8,7), (6,8,8), (6,8,9), (6,8,10), (6,9,1), (6,9,2), (6,9,3), (6,9,4), (6,9,5), (6,9,6), (6,9,7), (6,9,8), (6,9,9), (6,9,10), (6,10,1), (6,10,2), (6,10,3), (6,10,4), (6,10,5), (6,10,6), (6,10,7), (6,10,8), (6,10,9), (6,10,10), (7,1,1), (7,1,2), (7,1,3), (7,1,4), (7,1,5), (7,1,6), (7,1,7), (7,1,8), (7,1,9), (7,1,10), (7,2,1), (7,2,2), (7,2,3), (7,2,4), (7,2,5), (7,2,6), (7,2,7), (7,2,8), (7,2,9), (7,2,10), (7,3,1), (7,3,2), (7,3,3), (7,3,4), (7,3,5), (7,3,6), (7,3,7), (7,3,8), (7,3,9), (7,3,10), (7,4,1), (7,4,2), (7,4,3), (7,4,4), (7,4,5), (7,4,6), (7,4,7), (7,4,8), (7,4,9), (7,4,10), (7,5,1), (7,5,2), (7,5,3), (7,5,4), (7,5,5), (7,5,6), (7,5,7), (7,5,8), (7,5,9), (7,5,10), (7,6,1), (7,6,2), (7,6,3), (7,6,4), (7,6,5), (7,6,6), (7,6,7), (7,6,8), (7,6,9), (7,6,10), (7,7,1), (7,7,2), (7,7,3), (7,7,4), (7,7,5), (7,7,6), (7,7,7), (7,7,8), (7,7,9), (7,7,10), (7,8,1), (7,8,2), (7,8,3), (7,8,4), (7,8,5), (7,8,6), (7,8,7), (7,8,8), (7,8,9), (7,8,10), (7,9,1), (7,9,2), (7,9,3), (7,9,4), (7,9,5), (7,9,6), (7,9,7), (7,9,8), (7,9,9), (7,9,10), (7,10,1), (7,10,2), (7,10,3), (7,10,4), (7,10,5), (7,10,6), (7,10,7), (7,10,8), (7,10,9), (7,10,10), (8,1,1), (8,1,2), (8,1,3), (8,1,4), (8,1,5), (8,1,6), (8,1,7), (8,1,8), (8,1,9), (8,1,10), (8,2,1), (8,2,2), (8,2,3), (8,2,4), (8,2,5), (8,2,6), (8,2,7), (8,2,8), (8,2,9), (8,2,10), (8,3,1), (8,3,2), (8,3,3), (8,3,4), (8,3,5), (8,3,6), (8,3,7), (8,3,8), (8,3,9), (8,3,10), (8,4,1), (8,4,2), (8,4,3), (8,4,4), (8,4,5), (8,4,6), (8,4,7), (8,4,8), (8,4,9), (8,4,10), (8,5,1), (8,5,2), (8,5,3), (8,5,4), (8,5,5), (8,5,6), (8,5,7), (8,5,8), (8,5,9), (8,5,10), (8,6,1), (8,6,2), (8,6,3), (8,6,4), (8,6,5), (8,6,6), (8,6,7), (8,6,8), (8,6,9), (8,6,10), (8,7,1), (8,7,2), (8,7,3), (8,7,4), (8,7,5), (8,7,6), (8,7,7), (8,7,8), (8,7,9), (8,7,10), (8,8,1), (8,8,2), (8,8,3), (8,8,4), (8,8,5), (8,8,6), (8,8,7), (8,8,8), (8,8,9), (8,8,10), (8,9,1), (8,9,2), (8,9,3), (8,9,4), (8,9,5), (8,9,6), (8,9,7), (8,9,8), (8,9,9), (8,9,10), (8,10,1), (8,10,2), (8,10,3), (8,10,4), (8,10,5), (8,10,6), (8,10,7), (8,10,8), (8,10,9), (8,10,10), (9,1,1), (9,1,2), (9,1,3), (9,1,4), (9,1,5), (9,1,6), (9,1,7), (9,1,8), (9,1,9), (9,1,10), (9,2,1), (9,2,2), (9,2,3), (9,2,4), (9,2,5), (9,2,6), (9,2,7), (9,2,8), (9,2,9), (9,2,10), (9,3,1), (9,3,2), (9,3,3), (9,3,4), (9,3,5), (9,3,6), (9,3,7), (9,3,8), (9,3,9), (9,3,10), (9,4,1), (9,4,2), (9,4,3), (9,4,4), (9,4,5), (9,4,6), (9,4,7), (9,4,8), (9,4,9), (9,4,10), (9,5,1), (9,5,2), (9,5,3), (9,5,4), (9,5,5), (9,5,6), (9,5,7), (9,5,8), (9,5,9), (9,5,10), (9,6,1), (9,6,2), (9,6,3), (9,6,4), (9,6,5), (9,6,6), (9,6,7), (9,6,8), (9,6,9), (9,6,10), (9,7,1), (9,7,2), (9,7,3), (9,7,4), (9,7,5), (9,7,6), (9,7,7), (9,7,8), (9,7,9), (9,7,10), (9,8,1), (9,8,2), (9,8,3), (9,8,4), (9,8,5), (9,8,6), (9,8,7), (9,8,8), (9,8,9), (9,8,10), (9,9,1), (9,9,2), (9,9,3), (9,9,4), (9,9,5), (9,9,6), (9,9,7), (9,9,8), (9,9,9), (9,9,10), (9,10,1), (9,10,2), (9,10,3), (9,10,4), (9,10,5), (9,10,6), (9,10,7), (9,10,8), (9,10,9), (9,10,10), (10,1,1), (10,1,2), (10,1,3), (10,1,4), (10,1,5), (10,1,6), (10,1,7), (10,1,8), (10,1,9), (10,1,10), (10,2,1), (10,2,2), (10,2,3), (10,2,4), (10,2,5), (10,2,6), (10,2,7), (10,2,8), (10,2,9), (10,2,10), (10,3,1), (10,3,2), (10,3,3), (10,3,4), (10,3,5), (10,3,6), (10,3,7), (10,3,8), (10,3,9), (10,3,10), (10,4,1), (10,4,2), (10,4,3), (10,4,4), (10,4,5), (10,4,6), (10,4,7), (10,4,8), (10,4,9), (10,4,10), (10,5,1), (10,5,2), (10,5,3), (10,5,4), (10,5,5), (10,5,6), (10,5,7), (10,5,8), (10,5,9), (10,5,10), (10,6,1), (10,6,2), (10,6,3), (10,6,4), (10,6,5), (10,6,6), (10,6,7), (10,6,8), (10,6,9), (10,6,10), (10,7,1), (10,7,2), (10,7,3), (10,7,4), (10,7,5), (10,7,6), (10,7,7), (10,7,8), (10,7,9), (10,7,10), (10,8,1), (10,8,2), (10,8,3), (10,8,4), (10,8,5), (10,8,6), (10,8,7), (10,8,8), (10,8,9), (10,8,10), (10,9,1), (10,9,2), (10,9,3), (10,9,4), (10,9,5), (10,9,6), (10,9,7), (10,9,8), (10,9,9), (10,9,10), (10,10,1), (10,10,2), (10,10,3), (10,10,4), (10,10,5), (10,10,6), (10,10,7), (10,10,8), (10,10,9), (10,10,10))


// Produces all right triangles with sides up to 10 in length
val rightTriangles = (for(a1 <- 1 to 10; b1 <- 1 to 10; c1 <- 1 to 10)yield{((math.pow(a1, 2)) + math.pow(b1, 2) == math.pow(c1, 2) match{case true => Some(a1,b1,c1) case false => None})}).toList.flatten
// = List((3,4,5), (4,3,5), (6,8,10), (8,6,10))


// Produces all right triangles with sides up to 10 in length where the perimeter equals 24
val perimeterRightTriangles = (for(a1 <- 1 to 10; b1 <- 1 to 10; c1 <- 1 to 10)yield{(((math.pow(a1, 2)) + math.pow(b1, 2) == math.pow(c1, 2)) && (a1 + b1 + c1 == 24) match{case true => Some(a1,b1,c1) case false => None})}).toList.flatten
// = List((6,8,10), (8,6,10))
