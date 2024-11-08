def split2(list: List[Int], a: Int, b: Int): (List[Int],List[Int]) = {
        def checkNumberLower(list: List[Int], a: Int): List[Int] = {
                if list == Nil then Nil
                else if list.head <= a then
                        list.head :: checkNumberLower(list.tail, a)
                else checkNumberLower(list.tail, a)
        }

        def checkNumberHigher(list: List[Int], b: Int): List[Int] = {
                if list == Nil then Nil
                else if list.head >= b then
                        list.head :: checkNumberHigher(list.tail, b)
                else checkNumberHigher(list.tail, b)
        }

        if list == Nil then (Nil,Nil)
        else (checkNumberLower(list,a),checkNumberHigher(list,b))
}

val list1 = List(1,2,3,4)
split2(list1,3,2)


val list2 = List()
split2(list2,2,2)

