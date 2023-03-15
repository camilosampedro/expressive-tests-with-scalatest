package calculator

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpec

class E_CalculatorWordSpecWithMatchers
    extends AnyWordSpec
    with should.Matchers {

  "calculator" can {
    val calculator = new CalculatorImplementation

    "add" should {

      "add 3 and 4 and return 7" in {
        calculator.add(3, 4) shouldBe 7
//        calculator.add(3, 4) shouldBe 8
      }
    }

    "divide" should {

      "divide 9 over 3 and return 3" in {
        calculator.divide(9, 3) shouldBe Right(3)
      }

      "divide 9 by 0 and return an error" in {
        calculator.divide(9, 0) shouldBe a[Left[_, _]]
//        calculator.divide(9, 0) shouldBe a[Right[_, _]]
      }
    }
  }

}
