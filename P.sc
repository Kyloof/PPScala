val trip = (2.75,"OwO")
val f = (x:Int) => 2 * x
f(10)
def g(x:Double) = 3 - x
g(5)
val h = g _
h(5)
def h(pair:(Double,Double)) =
  val x = pair._1
  val y = pair._2
  x * x + y * y

h((5.0,2.0))

val z = (x:Double,y:Int) => x * x + y * y

z(5,2)

def c(x:Double, y:Double) = x*x + y*y

c(10,2)