package calculator

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.wordspec.AnyWordSpec

class D_CalculatorWordSpec extends AnyWordSpec {

  "calculator" can {
    val calculator = new CalculatorImplementation

    "add" should {

      "add 3 and 4 and return 7" in {
        assert(calculator.add(3, 4) == 7)
      }
    }

    "divide" should {

      "divide 9 over 3 and return 3" in {
        assert(calculator.divide(9, 3) == Right(3))
      }

      "divide 9 by 0 and return an error" in {
        assert(calculator.divide(9, 0).isLeft)
      }
    }
  }

}
