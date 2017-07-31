// Finds the maximum in an inputted list.

def maximum(theList:List[Any]):Any = {
  theList match {
    case Nil => "Maximum of empty lists"
    case x::Nil => x
    case x::xs => math.max(x.asInstanceOf[Int], maximum(theList.tail).asInstanceOf[Int])
  }
}

maximum(List(1,2,6,0,3))  // = 6

// Creates a list of 'x' number repeated 'y' times.
def replicate(theNum:Int, theTimes:Int, theList:List[Int]):Any = {
  (theNum, theTimes) match {
    case x if x._2 <= 0 => theList
    case _ => replicate(theNum, theTimes - 1, theList :+ theNum)
  }
}

replicate(3,5,List())  // = List(3,3,3,3,3)

// Retrieves the first 'x' elements from 'y' list.
def take(theNum:Int, inList:List[Any], theList:List[Any]):Any = {
  theNum match {
    case x if x <= 0 => theList.reverse
    case x if inList.length <= theNum => "The list is too short."
    case _ => take(theNum - 1, inList, theList :+ inList(theNum -1))
  }
}

take(3, List(1,2,3,4,5), List())  // = List(1,2,3)

// Reverse function. Reverses a list.
def reverse(list:List[Any], result:List[Any] = Nil):List[Any] = {
  list match {
    case Nil => result
    case (x :: xs) => reverse(xs, x :: result)
  }
}

val revList = List(1,2,3,4,5)
reverse(revList, List())
// = List(5,4,3,2,1)


// Zip function. Combines list elements from two lists into tuples.
def zip(listA:List[Any], listB:List[Any]) = {
  (listA, listB) match {
    case x if x._1.isEmpty || x._2.isEmpty => List()
    case _ => listA.zip(listB)
  }
}

zip(List(1,2,3), List('a', 'b'))
// = List((1,a), (2,b))


// Find out if an element is in a given list.

def findElem(theList:List[Any], theElem:Any):Any = {
  theList match {
    case Nil => false
    case x if theList.head == theElem => true
    case _ => findElem(theList.tail, theElem)
  }
}

findElem(List(1,2,3,4,5), 4)  // = true
findElem(List('a','b','c'), 'z') // = false

// Quicksort. Sorts a list into ascending order.
def sort(xs:List[Int]):List[Int] = {
  if (xs.length <= 1) xs
  else {
    val pivot = xs(xs.length / 2)
    List.concat(
      sort(xs filter (pivot >)),
      xs filter (pivot ==),
      sort(xs filter (pivot <)))
  }
}

sort(List(10,2,5,3,1,6,7,4,2,3,4,8,9))
// = Array(1, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 10)