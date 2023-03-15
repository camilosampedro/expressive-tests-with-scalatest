package calculator

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class F_CalculatorWordSpecWithTables
    extends AnyWordSpec
    with should.Matchers
    with TableDrivenPropertyChecks {

  "calculator" should {
    val calculator = new CalculatorImplementation

    val addCases = Table(
      ("a", "b", "expectedResult"),
      (3d, 4d, 7d),
      (5000d, 25000d, 30000d),
      (1.25, 3.25, 4.5)
    )
    "add two positive numbers" in forAll(addCases) { (a, b, expectedResult) =>
      calculator.add(a, b) shouldBe expectedResult
    //      calculator.add(3, 4) shouldBe 8
    }

    val divideCases = Table(
      ("a", "b", "expectedResult"),
      (15d, 4d, 3.75d),
      (80000d, 10000d, 8d),
      (1.25, -3.25, -0.38461538461538464)
    )
    "divide should divide numbers" in forAll(divideCases) {
      (a, b, expectedResult) =>
//        calculator.divide(a, b) shouldBe Right(expectedResult)
        calculator.divide(a, b) shouldBe Right(expectedResult)
    }

    val divideByZeroCases = Table(
      "num",
      15d,
      80000d,
      1.25d
    )
    "divide by zero should return an error" in forAll(divideByZeroCases) {
      num =>
        //        calculator.divide(num, 0) shouldBe a[Right[_, _]]
        calculator.divide(num, 0) shouldBe a[Left[_, _]]
    }
  }

}
