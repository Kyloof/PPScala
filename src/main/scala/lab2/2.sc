import scala.annotation.tailrec

def split3Rec[A](list: List[A]): (List[A], List[A], List[A]) = {
  list match {

    case hd1 :: hd2 :: hd3 :: t =>
      val (l1, l2, l3) = split3Rec(t)
      (hd1 :: l1, hd2 :: l2, hd3 :: l3)
    case _ => (Nil, Nil, Nil)
  }
}

split3Rec(List())
split3Rec(List(1, 2, 3))
split3Rec(List(1, 2, 3, 4))
split3Rec(List(1, 2, 3, 4, 5))
split3Rec(List(1, 2, 3, 4, 5, 6))


def split3RecTail[A](list: List[A]): (List[A], List[A], List[A]) = {
  @tailrec
  def split3RecTailAcc(list:List[A], acc1: List[A], acc2: List[A], acc3: List[A]): (List[A], List[A], List[A]) = {
    list match{
      case hd1::hd2::hd3::tl =>
        split3RecTailAcc(tl, hd1::acc1, hd2::acc2, hd3::acc3)
      case _ => (acc1,acc2,acc3)
    }
  }
  split3RecTailAcc(list, Nil, Nil, Nil)
}

split3RecTail(List())
split3RecTail(List(1, 2, 3))
split3RecTail(List(1, 2, 3, 4))
split3RecTail(List(1, 2, 3, 4, 5))
split3RecTail(List(1, 2, 3, 4, 5, 6))

