package calculator

import org.scalatest.funsuite.AnyFunSuite

class A_CalculatorFunSuite extends AnyFunSuite {

  test("add should add 3 and 4 and return 7") {
    val calculator = new CalculatorImplementation

    assert(calculator.add(3, 4) == 7)
  }

  test("add should add 3 and -4 and return -1") {
    val calculator = new CalculatorImplementation

    assert(calculator.add(3, -4) == -1)
  }

  test("multiply should multiply 3 and 5 and return 15") {
    val calculator = new CalculatorImplementation

    assert(calculator.multiply(3, 5) == 15)
  }

  test("divide should divide 9 over 3 and return 3") {
    val calculator = new CalculatorImplementation

    assert(calculator.divide(9, 3) == Right(3))
  }

  test("divide 9 by 0 should return an error") {
    val calculator = new CalculatorImplementation

    assert(calculator.divide(9, 0).isLeft)
  }

}
