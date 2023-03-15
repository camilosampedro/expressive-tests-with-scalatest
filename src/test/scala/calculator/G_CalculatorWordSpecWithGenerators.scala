package calculator

import org.scalacheck.Gen
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class G_CalculatorWordSpecWithGenerators
    extends AnyWordSpec
    with should.Matchers
    with TableDrivenPropertyChecks
    with ScalaCheckPropertyChecks {

  "calculator" can {
    val calculator = new CalculatorImplementation

    "add" should {
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

      "add two positive numbers and produce positive numbers" in forAll(
        Gen.posNum[Double],
        // Try with Gen.negNum[Double] to see negative numbers
        Gen.posNum[Double]
      ) { (a, b) =>
        calculator.add(a, b) should be >= 0d
      }
    }

    "divide" should {

      val divideCases = Table(
        ("a", "b", "expectedResult"),
        (15d, 4d, 3.75d),
        (80000d, 10000d, 8d),
        (1.25, -3.25, -0.38461538461538464)
      )
      "divide numbers and give the expected result" in forAll(divideCases) {
        (a, b, expectedResult) =>
          //        calculator.divide(a, b) shouldBe Right(expectedResult)
          calculator.divide(a, b) shouldBe Right(expectedResult)
      }

      "divide by zero should always return an error" in forAll {
        (num: Double) =>
          //      calculator.divide(num, 0) shouldBe a[Right[_, _]]
          calculator.divide(num, 0) shouldBe a[Left[_, _]]
      }
    }
  }

}
