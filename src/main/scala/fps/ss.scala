package fps

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
	def sum(ints: List[Int]): Int = ints match {
		case Nil => 0
		case Cons(x, xs) => x + sum(xs)
	}

	def product(ds: List[Double]): Double = ds match {
		case Nil => 1.0
		case Cons(0.0, _) => 0.0
		case Cons(x, xs) => x * product(xs)
	}

	/** A* は可変長引数 */
	def apply[A](as: A*): List[A] =
		if (as.isEmpty) Nil
		else Cons(as.head, apply(as.tail: _*) )

}

object FPS2
{
    /** EX 2-1 フィボナッチ数 */
    def fib(n : Int) : Int = n match {
    case 0 => 0
    case 1 => 1
    case n => fib(n - 1) + fib(n - 2)
    }

    /** EX 2-2 Array のソートチェック */
    def isSorted[T](arr : Array[T], ordered : (T, T) => Boolean) : Boolean = {
        def loop(i : Int) : Boolean = {
            if (i >= arr.length) true
            else if(ordered(arr(i - 1), arr(i)) == false) false
            else loop(i + 1)
        }

        if(arr.length <= 1) true

        loop(1)
    }

    /** EX 2-3 Curry */
	def curry[A, B, C] (f: (A, B) => C) : A => (B => C) = {

//		def temp1(a : A) : (B => C) = {
//			def temp2( b : B) : C = {
//				f(a, b)
//			}
//			temp2
//		}
//		temp1

		(a : A) => ( (b : B) => f(a, b) )
	}

	/** Uncurry */
	def uncurry[A, B, C](f : A => (B => C) ) : (A, B) => C = {
//		def temp(a : A, b : B) : C = {
//			f(a)(b)
//		}
//
//		temp
		(a : A, b : B) => f(a)(b)
	}

	/** Ex 2-5 2つの関数を合成する高階関数を作成せよ */
	def compose[A, B, C] (f : B => C, g : A => B) : A => C = {
		(a : A) => f(g(a))
	}

	/** EX 3-1 以下のマッチ式はどのような結果になるか */
	val x = List(1, 2, 3, 4, 5) match {
	case Cons(x, Cons(2, Cons(4, _) ) ) => x
	case Nil => 42
	case Cons(x, Cons(y, Cons(3, Cons(4, _) ) ) ) => x + y
	case _ => 101
	}
}
