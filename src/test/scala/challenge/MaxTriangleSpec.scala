package challenge

import org.scalatest._

class MaxTriangleSpec extends FlatSpec with Matchers {

  val tri = new MaxTriangle()

  // test
  "MaxTriangleSpec" should "have tests" in {

    tri.solve(List(1)) shouldEqual 0
    tri.solve(List(4, 5, 10, 20)) shouldEqual 100

  }
}
