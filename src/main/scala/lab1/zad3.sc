
def insert[A](x: A, list: List[A], pos: Int): List[A] = {
  if (pos < 1) then
    x :: list
  else if (list == Nil) then
    List(x)
  else
    list.head :: insert(x, list.tail, pos - 1)
}


val list1 = List(1, 2, 3, 4, 5)
insert(0,list1,10)

val list2 = List("BEKA", "XD", "LOL","HAHA" )
insert("DX",list2,2)

val list3 = List()
insert(true, list3,3)