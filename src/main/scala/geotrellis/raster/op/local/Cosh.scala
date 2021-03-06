package geotrellis.raster.op.local

import geotrellis._

/**
 * Operation to get the hyperbolic cosine of values.
 */
object Cosh extends Serializable {
  /** Takes the hyperboic cosine of each raster cell value.
    * Always returns a double raster.
    */
  def apply(r:Op[Raster]) =
    r.map(y => y.convert(TypeDouble)
                .mapDouble(z => math.cosh(z)))
     .withName("Cosh")
}
