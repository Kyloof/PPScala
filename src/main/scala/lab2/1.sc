import scala.annotation.tailrec

def indexSwap[A](a: Int, b: Int, list: List[A]): List[A] = {


    val (aSwap, bSwap) = if (a < 0 || b < 0) {
      (-1, -1)
    } else if (a > b) {
      (b, a)
    } else {
      (a, b)
    }

    bSwap match {
      case -1 => list
      case _ =>
        def swapRecursive(index: Int, valueOfA: A, valueOfB: A, listTail: List[A]): List[A] = {
          valueOfB match {
            case -1 => listTail
            case _ =>
              listTail match {
                case Nil => Nil
                case head :: tail =>
                  index match {
                    case `aSwap` =>
                      valueOfB :: swapRecursive(index + 1, head, valueOfB, tail)
                    case `bSwap` =>
                      valueOfA :: swapRecursive(index + 1, valueOfA, valueOfB, tail)
                    case _ =>
                      head :: swapRecursive(index + 1, valueOfA, valueOfB, tail)
                  }
              }
          }
        }

        @tailrec
        def getElements(index: Int, list: List[A], result: List[A]): List[A] = {
          list match {
            case Nil => Nil
            case head :: tail =>
              index match {
                case `aSwap` => getElements(index + 1, tail, head :: result)
                case `bSwap` => head::result
                case _ => getElements(index + 1, tail, result)
              }
          }
        }
        val pos = getElements(0, list, Nil)

        pos match {
          case firstElement :: secondElement :: tl =>
            println("weszło w rekurencje")
            val (valueA, valueB) = (secondElement, firstElement)

            swapRecursive(0, valueA, valueB, list)
          case _ =>
            list
        }
    }


}




val lista = List(1, 2, 3, 4, 5, 6)
val indexSwap15: List[Int] => List[Int] = list => indexSwap(1, 5, list)
val indexSwapMinus15: List[Int] => List[Int] = list => indexSwap(-1, 5, list)
val indexSwap129: List[Int] => List[Int] = list => indexSwap(1, 29, list)
val indexSwap00: List[Int] => List[Int] = list => indexSwap(0, 0, list)


val wynik = indexSwap15(lista)
val wynik2 = indexSwapMinus15(lista)
val wynik3 = indexSwap00(lista)
val wynik5 = indexSwap129(lista)

val listaPusta = List()
val wynik4 = indexSwap15(listaPusta)