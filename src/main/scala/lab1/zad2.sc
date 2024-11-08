def inList[A](x: A, y: List[A]): Boolean = {
  if (y.isEmpty) false
  else if (x == y.head) true
  else inList(x, y.tail)
}


//def evaluates when called
def hits[A](x: List[A], y: List[A]): List[A] = {
  if (x.isEmpty || y.isEmpty) then
    Nil
  else
    if (inList(x.head, y)) then
      x.head :: hits(x.tail, y)
    else
      hits(x.tail, y)
}


val list1 = List(1, 2, 3, 4)
val list2 = List(3, 4, 5, 6)

val list3 = List("HEHE","HAHA","HH","XD")
val list4 = List("BEKA", "XD", "LOL","HAHA" )

val list5 = List()
val list6 = List(3, 4, 5, 6)
hits(list1,list2)
hits(list4,list3)
hits(list5,list6)