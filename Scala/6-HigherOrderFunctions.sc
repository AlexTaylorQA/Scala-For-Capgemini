// Higher Order Functions

// Takes three numbers and multiplies them together.
// Curried function allows partial execution of the function.

def multThree(x:Int)(y:Int)(z:Int) = {x * y * z}

val multTwoWithNine = multThree(9)_
multTwoWithNine(2)(3)  // = 2 * 3 * 9 = 54
val multWithEighteen = multTwoWithNine(2)​
multWithEighteen(10)

// = multTwoWithNine(2)(10)
// = multThree(9)(2)(10)
// = 9 * 2 * 10
// = 180

// Checks if an inputted number is greater than, less than, or equal to 100.
val compareWithHundred: Int => Int = _.compare(100)
compareWithHundred(99)
// = -1 (Less than)

// Divides an inputted number by 10.
val divideByTen: Float => Float = _ `/` 10
divideByTen(200)
// = 20.0

// Checks if an inputted character is an uppercase letter.
val isUpperAlphaNum: Char => Boolean = _.isUpper
isUpperAlphaNum('A')
// = true

// Takes in a function and an input, and applies the function to the number twice.
def applyTwice(f:(Any => Any), x:Any) = f(f(x))
applyTwice((_.asInstanceOf[Int] `+` 3), 10)
// = 10 +3 +3 = 16

applyTwice((_ `+` " HAHA"), "HEY")
// = "HEY" + " HAHA" + " HAHA" = "HEY HAHA HAHA"

applyTwice((multThree(2)(2)_).asInstanceOf[Any=>Any], 9)
// = 2 * 2 * (2 * 2 * (9)) = (4 * 4 * 9) = (4 * 36) = 144

/*
def zipWith(f:Any => Any, x:List[Int], y:List[Int]) = f((x)(y))

zipWith(`+`_, List(1), List(2))
*/
