package calculator

import org.scalatest.EitherValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class H_CalculatorWordSpecWithEitherValues
    extends AnyWordSpec
    with should.Matchers
    with TableDrivenPropertyChecks
    with EitherValues {

  "calculator" should {
    val calculator = new CalculatorImplementation

    val divideCases = Table(
      ("a", "b", "expectedResult"),
      (15d, 4d, 3.75d),
      (80000d, 10000d, 8d),
      (1.25, -3.25, -0.38461538461538464)
    )
    "divide should divide numbers" in forAll(divideCases) {
      (a, b, expectedResult) =>
//        calculator.divide(a, 0).value shouldBe expectedResult
        calculator.divide(a, b).value shouldBe expectedResult
    }

    val divideByZeroCases = Table(
      "num",
      15d,
      80000d,
      1.25d
    )
    "divide by zero should return an error" in forAll(divideByZeroCases) {
      num =>
        //         calculator.divide(num, 0).left shouldBe an[NullPointerException]
        calculator.divide(num, 0).left.value shouldBe an[ArithmeticException]
    }
  }

}
