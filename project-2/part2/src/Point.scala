import scala.annotation.targetName

/** A (2D) point, consisting of x- and y-coordinates. */
case class Point(x: Double, y: Double) {

  // Add the following to this class:

  // Operator overload: Point + Vector => Point
  // (x, y) + [a, b] = (x + a, y + b)
  @targetName("add")
  infix def +(f: Vector): Point =
    Point(x + f.x, y + f.y)

  // Operator overload: Point - Vector => Point
  // (x, y) - [a, b] = (x - a, y - b)
  @targetName("subtract")
  infix def -(f: Vector): Point =
    Point(x - f.x, y - f.y)

  // Operator overload: Point - Point => Vector
  // (x, y) - (z, w) = [x - z, y - w]
  @targetName("subtract")
  infix def -(f: Point): Vector =
    Vector(x - f.x, y - f.y)

  // Override toString to return the form "(x, y)"
  override def toString: String =
    s"($x, $y)"
}