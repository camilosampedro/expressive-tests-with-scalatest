package calculator

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funspec.AnyFunSpec

class C_CalculatorFunSpec extends AnyFunSpec {

  describe("calculator") {
    val calculator = new CalculatorImplementation
    describe("add") {
      it("should add 3 and 4 and return 7") {
        assert(calculator.add(3, 4) == 7)
        // assert(calculator.add(3, 4) == 8)
      }

      it("should add 3 and -4 and return -1") {
        assert(calculator.add(3, -4) == -1)
      }
    }

    describe("divide") {
      it("should divide 9 by 3 and return 3") {
        assert(calculator.divide(9, 3) == Right(3))
      }

      it("should divide 9 by 0 and return an error") {
        assert(calculator.divide(9, 0).isLeft)
      }
    }
  }

}
