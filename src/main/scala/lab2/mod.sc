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
      def swapRecursive(index: Int, reverseValues: List[A], listTail: List[A]): List[A] = {
        listTail match {
          case Nil => Nil
          case head :: tail =>
            reverseValues match {
              case Nil => head :: swapRecursive(index + 1, reverseValues, tail)
              case hd :: tl =>
                if (aSwap <= index && bSwap >= index) {
                  hd :: swapRecursive(index + 1, tl, tail)
                } else {
                  head :: swapRecursive(index + 1, reverseValues, tail)
                }
            }
        }
      }

      @tailrec
      def getElements(index: Int, list: List[A], result: List[A]): List[A] = {

        list match {
          case Nil => Nil
          case head :: tail =>
            if (aSwap <= index && bSwap > index){
              getElements(index + 1, tail, head::result)
            }
            else if (index >= bSwap) {
                head::result
            }
            else {
              getElements(index + 1, tail, result)
            }
        }
      }
      val swapList = getElements(0, list, Nil)

      swapList match {
        case firstElement :: tl =>
          swapRecursive(0, swapList, list)
        case _ =>
          list
      }
  }


}




val lista = List(1, 2, 3, 4, 5, 6)
val indexSwap24: List[Int] => List[Int] = list => indexSwap(2, 4, list)
val indexSwap15: List[Int] => List[Int] = list => indexSwap(1, 5, list)
val indexSwapMinus15: List[Int] => List[Int] = list => indexSwap(-1, 5, list)
val indexSwap129: List[Int] => List[Int] = list => indexSwap(1, 29, list)
val indexSwap00: List[Int] => List[Int] = list => indexSwap(0, 0, list)


val wynik = indexSwap15(lista)
val wynik2 = indexSwapMinus15(lista)
val wynik3 = indexSwap00(lista)
val wynik4 = indexSwap24(lista)
val wynik5 = indexSwap129(lista)

val listaPusta = List()
val wynik6 = indexSwap15(listaPusta)