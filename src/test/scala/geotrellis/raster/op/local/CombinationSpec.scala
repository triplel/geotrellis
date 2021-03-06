package geotrellis.raster.op.local

import geotrellis._

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

import geotrellis.testutil._

// @org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
// class CombinationSpec extends FunSpec 
//                  with ShouldMatchers 
//                  with TestServer 
//                  with RasterBuilders {
//   describe("Combination") {
//     it("gives correct number of combinations for simple case") {
//       val r1 = 
//         createRaster(Array(
//           1, 2, 3, 4,
//           1, 2, 3, 4,
//           1, 2, 3, 4), 4, 3)

//       val r2 = 
//         createRaster(Array(
//           4, 1, 2, 3,
//           4, 1, 2, 3,
//           4, 1, 2, 3), 4, 3)

//       val r3 = 
//         createRaster(Array(
//           3, 4, 1, 2,
//           3, 4, 1, 2,
//           3, 4, 1, 2), 4, 3)

//       run(Combination(r1,r2,r3)).findMinMax._2 should be (3)
//     }

//     it("gives correct number of combinations for a case where all combos are unique") {
//       val r1 = 
//         createRaster(Array(
//           1, 2, 3, 4,
//           2, 3, 4, 1,
//           3, 4, 1, 2), 4, 3)

//       val r2 = 
//         createRaster(Array(
//           4, 1, 2, 3,
//           3, 4, 1, 2,
//           2, 3, 1, 4), 4, 3)

//       val r3 = 
//         createRaster(Array(
//           3, 4, 2, 1,
//           2, 3, 1, 4,
//           4, 3, 2, 1), 4, 3)

//       run(Combination(r1,r2,r3)).findMinMax._2 should be (4*3 - 1)
//     }

//     it("takes combinations on raster sources of varying values") {
//       val n = NODATA
//       val rs1 = createRasterSource(Array(
//         n, 1, n,   1, n, 1,
//         2, n, 2,   n, 2, n,

//         n, 3, n,   3, n, 3,
//         4, n, 4,   n, 4, n), 2, 2, 3,2)

//       val rs2 = createRasterSource(Array(
//         1, n, n,   n, n, 10,
//         1, n, n,   n, n, 9,

//         1, n, n,   n, n, 8,
//         1, n, n,   n, n, 7 ), 2, 2, 3, 2)

//       val rs3 = createRasterSource(Array(
//         n, 8, n,   9, n, 1,
//         n, n, n,   7, 2, n,

//         n, 8, n,   5, 2, n,
//         n, 8, n,   3, 4, n), 2, 2, 3, 2)

//       run(rs1.localMean(rs2, rs3)) match {
//         case Complete(result,success) =>
// //          println(success)
//           result.findMinMax._2 should be (
//         case Error(msg,failure) =>
//           println(msg)
//           println(failure)
//           assert(false)
//       }
//     }

//     it("takes combinations on double raster sources of varying values") {
//       val rs1 = createRasterSource(Array(
//         NaN, 1.0, NaN,   1.0, NaN, 1.0,
//         2.0, NaN, 2.0,   NaN, 2.0, NaN,

//         NaN, 3.5, NaN,   3.5, NaN, 3.5,
//         4.1, NaN, 4.1,   NaN, 4.1, NaN), 
//         2, 2, 3,2)

//       val rs2 = createRasterSource(Array(
//         1.0, NaN, NaN,   NaN, NaN, 10.4,
//         1.0, NaN, NaN,   NaN, NaN, 9.4,

//         1.0, NaN, NaN,   NaN, NaN, 8.3,
//         1.0, NaN, NaN,   NaN, NaN, 7.3 ), 2, 2, 3, 2)

//       val rs3 = createRasterSource(Array(
//         NaN, 8.3, NaN,   9.1, NaN, 1.2,
//         NaN, NaN, NaN,   7.1, 2.2, NaN,

//         NaN, 8.3, NaN,   5.1, 2.2, NaN,
//         NaN, 8.3, NaN,   3.1, 4.2, NaN), 2, 2, 3, 2)

//       val expected = Array(
//               1.0, (8.3+1.0)/2, NaN, (9.1+1.0)/2,       NaN, (1.2+10.4+1.0)/3,
//         (2.0+1.0)/2,       NaN, 2.0,         7.1, (2.2+2.0)/2,          9.4,
//               1.0, (8.3+3.5)/2, NaN, (3.5+5.1)/2,       2.2,    (8.3+3.5)/2,
//         (4.1+1.0)/2,       8.3, 4.1,       3.1, (4.2+4.1)/2,          7.3
//       )

//       run(rs1.localMean(rs2, rs3)) match {
//         case Complete(result,success) =>
// //          println(success)
//           for(row <- 0 until 4) {
//             for(col <- 0 until 6) {
//               if(isNoData(expected(row*6+col))) { isNoData(result.getDouble(col,row)) should be (true) }
//               else { result.getDouble(col,row) should be (expected(row*6 + col)) }
//             }
//           }
//         case Error(msg,failure) =>
//           println(msg)
//           println(failure)
//           assert(false)
//       }
//     }
//   }
// }
