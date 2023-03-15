package calculator

trait Calculator {
  def add(a: Double, b: Double): Double
  def multiply(a: Double, b: Double): Double
  def divide(a: Double, b: Double): Either[Throwable, Double]
}
