package geotrellis.spark.storage
import geotrellis.spark.TestEnvironment

import geotrellis.spark.utils.SparkUtils

class RasterReaderSpec extends TestEnvironment {
  val conf = SparkUtils.createHadoopConfiguration

  describe("RasterReader") {
	// nothing here for now, IngestSpec covers a basic test  
  }
}