package calculator

import org.scalatest.flatspec.AnyFlatSpec

class B_CalculatorFlatSpec extends AnyFlatSpec {

  val calculator = new CalculatorImplementation

  "calculator" should "add 3 and 4 and return 7" in {
    assert(calculator.add(3, 4) == 7)
//    assert(calculator.add(3, 4) == 8)
  }

  it should "add 3 and -4 and return -1" in {
    assert(calculator.add(3, -4) == -1)
  }

  it should "divide divide 9 over 3 and return 3" in {
    assert(calculator.divide(9, 3) == Right(3))
  }

  it should "divide 9 by 0 and return an error" in {
    assert(calculator.divide(9, 0).isLeft)
  }

}
