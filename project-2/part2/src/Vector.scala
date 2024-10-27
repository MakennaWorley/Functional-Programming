import scala.annotation.targetName

/** A (2D) vector, consisting of an x (horizontal component) and y (vertical component) */
case class Vector(x: Double, y: Double):

  // Add the following to this class:
  
  // Operator overload: Vector * Double => Vector
  // [x, y] * a = [x * a, y * z]
  @targetName("multiply")
  infix def *(scalar: Double): Vector =
    Vector(x * scalar, y * scalar)
  
  // Operator overload: Vector + Vector => Vector
  // [x, y] + [z, w] = [x + z, y + w]
  @targetName("add vectors")
  infix def +(f: Vector): Vector =
    Vector(x + f.x, y + f.y)
  
  // Operator overload: Vector - Vector => Vector
  // [x, y] - [z, w] = [x - z, y - w]
  @targetName("subtract")
  infix def -(f: Vector): Vector =
    Vector(x - f.x, y - f.y)
  
  // Operator overload: Vector + Point => Point
  // [x, y] + (p, q) = (x + p, y + q)
  @targetName("add")
  infix def +(f: Point): Point =
    Point(x + f.x, y + f.y)
  
  // Operator overload: -Vector => Vector
  // -[x, y] = [-x, -y]
  // (Remember that you'll need to call this one `unary_-`)
  @targetName("negation")
  def `unary_-`: Vector =
    Vector(-x, -y)

  @targetName("inverse")
  infix def inverse(f: Vector): Vector =
    -this
  
  // Operator: Vector dot Vector => Double
  // [x, y] dot [z, w] = x*z + y*w
  // (You can define this just the same as the operator overloads,
  // but with infix: "infix def dot...")
  @targetName("dot product")
  infix def dot(f: Vector): Double =
    ((x * f.x) + (y * f.y))

  // Override toString to return the form "[x, y]"
  override def toString: String =
    s"[$x, $y]"
  
  def length: Double =
    Math.sqrt(x * x + y * y)
  
  /** Projects this vector onto other */
  def projection(other: Vector) =
    other * ((this dot other) / (other dot other))

  /** Reflects this vector about other */
  def reflect(other: Vector) =
    this - this.projection(other) * 2
  
  /** Rotates this vector by the given angle (in radians) */
  def rotate(angle: Double): Vector =
    Vector(x * Math.cos(angle) + y * Math.sin(angle),
           y * Math.cos(angle) - x * Math.sin(angle))
