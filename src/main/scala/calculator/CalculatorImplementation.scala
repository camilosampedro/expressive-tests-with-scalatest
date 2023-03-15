package calculator

class CalculatorImplementation extends Calculator {
  override def add(a: Double, b: Double): Double =
    a + b

  override def multiply(a: Double, b: Double): Double =
    a * b

  override def divide(a: Double, b: Double): Either[Throwable, Double] =
    if (b == 0)
      Left(new ArithmeticException("Dividing by zero"))
    else
      Right(a / b)
}
