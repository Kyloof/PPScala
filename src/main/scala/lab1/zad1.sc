//val evaluates when defined
def fiddle4[A,B](num:(A,Double,Double,B)) =
  (num._4,num._1,num._3 - num._2)
fiddle4(1.3, 2.0, 3.1, 4.2)