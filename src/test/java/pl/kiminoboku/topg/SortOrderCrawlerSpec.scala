import org.scalatest._

import scala.collection.JavaConverters._

package pl.kiminoboku.topg {

  class SortOrderCrawlerSpec extends FlatSpec with Matchers {
    "A SortOrderCrawler" should "try to not repeat compare pairs whenever possible" in {
      val list = List("A", "B", "C", "D")
      val crawler = new SortOrderCrawler(list.asJavaCollection)
      val comparePairs = crawler.comparePairs.asScala

      assert(comparePairs(0) === ("A", "B"))
      assert(comparePairs(1) === ("C", "D"))
      assert(comparePairs(2) === ("B", "D"))
      assert(comparePairs(3) === ("A", "C"))
      assert(comparePairs(4) === ("B", "C"))
      assert(comparePairs(5) === ("A", "D"))
    }

    it should "have size equal to factorial of input size" in {
      val list = List("1", "2", "3", "4")
      val expectedSize = 1 * 2 * 3 * 4
      val crawler = new SortOrderCrawler(list.asJavaCollection)

      assert(crawler.size === expectedSize)
    }
  }
}