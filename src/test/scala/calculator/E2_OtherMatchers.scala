package calculator

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpec

class E2_OtherMatchers extends AnyWordSpec with should.Matchers {

  "A List" when {
    "empty" should {
      "be empty" in {
        List.empty should be(empty)
      }
    }

    "it's List(1,2,3)" should {
      "contain 2" in {
        List(1, 2, 3) should contain(2)
      }

      "not contain 4" in {
        List(1, 2, 3) should not contain (4)
      }
    }
  }

  "A 'Lorem ipsum' string" should {
    "start with Lorem" in {
      "Lorem ipsum" should startWith("Lorem")
    }
  }

  "A '0.4991823798174'" should {
    "be approximately 0.4991823" in {
//      0.4991823798174 shouldBe 0.4991823
      0.4991823798174 shouldBe 0.4991823 +- 0.0000001
    }

    "be greater than 0.4" in {
      0.4991823798174 should be > 0.4
    }
  }

}
