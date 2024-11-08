def split2(list: List[Int], a: Int, b: Int): (List[Int], List[Int]) = {
  if list == Nil then (Nil,Nil)
  def checkNumbers(list: List[Int], lower: List[Int], higher: List[Int]): (List[Int], List[Int]) = {
    if (list == Nil) then (lower, higher)
    else {
      val (newLess, newMore) = checkNumbers(list.tail, lower, higher)
      val less = if list.head <= a then list.head :: newLess
      else newLess
      val more = if list.head >= b then list.head :: newMore
      else newMore
      (less, more)
    }
  }
  checkNumbers(list, Nil, Nil)
}

val list1 = List(1, 2, 3, 4)
split2(list1, 3, 2)

val list2 = List()
split2(list2, 2, 2)
