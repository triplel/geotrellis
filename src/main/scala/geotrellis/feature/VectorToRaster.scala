package geotrellis.feature

import geotrellis._
import geotrellis.raster._
import geotrellis.source._
import geotrellis.process._
import geotrellis.feature.op.geometry._
import geotrellis.feature.rasterize._

object VectorToRaster { 
  def kernelDensity[D](points: Seq[Point[D]], 
                       kernel: Kernel, 
                       rasterExtent: RasterExtent)
                      (implicit transform:D => Int): RasterSource =
    kernelDensity(points, transform, kernel, rasterExtent)

  def kernelDensity[D](points: Seq[Point[D]], 
                       transform: D => Int, 
                       kernel: Kernel, 
                       rasterExtent: RasterExtent): RasterSource = {
    val rd =
      RasterDefinition(
        LayerId.MEM_RASTER,
        rasterExtent,
        TileLayout.singleTile(rasterExtent),
        TypeInt,
        false)
    RasterSource(rd, Seq(KernelDensity(points,transform,kernel,rasterExtent)))
  }

  def idwInterpolate(points: Seq[Point[Int]], re: RasterExtent): RasterSource =
    idwInterpolate(points, re, None)

  def idwInterpolate(points: Seq[Point[Int]], re: RasterExtent, radius: Int): RasterSource =
    idwInterpolate(points, re, Some(radius))

  def idwInterpolate(points: Seq[Point[Int]], re: RasterExtent, radius: Option[Int]): RasterSource = {
    val rd =
      RasterDefinition(
        LayerId.MEM_RASTER,
        re,
        TileLayout.singleTile(re),
        TypeInt,
        false)
    RasterSource(rd, Seq(IDWInterpolate(points, re, radius)))
  }

  def rasterize[D](feature:Geometry[D], 
                   rasterExtent:RasterExtent)
                  (f:Transformer[Geometry,D,Int]): RasterSource = {
    val rd =
      RasterDefinition(
        LayerId.MEM_RASTER,
        rasterExtent,
        TileLayout.singleTile(rasterExtent),
        TypeInt,
        false)

    val r = geotrellis.op(Rasterizer.rasterize(feature, rasterExtent)(f))
    RasterSource(rd,Seq(r))
  }

  def rasterize[D](feature:Geometry[D], 
                   rasterExtent:RasterExtent,
                   value:Int): RasterSource = {
    val rd =
      RasterDefinition(
        LayerId.MEM_RASTER,
        rasterExtent,
        TileLayout.singleTile(rasterExtent),
        TypeInt,
        false)

    val r = geotrellis.op(Rasterizer.rasterizeWithValue(feature, rasterExtent, value))
    RasterSource(rd,Seq(r))
  }
}
