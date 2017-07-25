import scala.io.Source
import org.json4s._
import org.json4s.jackson.JsonMethods._

object findJson {
  def main(args: Array[String]): Unit = {
    var counter = 0
    (0 to 1).foreach{ i =>
      val textfileLine = Source.fromFile("""src\main\resources\""" + i +".txt").getLines()
      textfileLine.foreach{line =>
        val jsonObj = parse(line)
        val map = jsonObj.asInstanceOf[JObject].values
        if(map.get("number").get != None){
          println("number is " + map.get("number"))
          counter += 1
        }
      }

    }
    println("counter is " + counter)
  }
}
