package fr.esgi.funcProg

object HelloWorld {
  def main(args: Array[String]): Unit = {
    val text = """It is a period of civil wars in the galaxy. A brave alliance of
      underground freedom fighters has challenged the tyranny and oppression of the awesome
      GALACTIC EMPIRE.
      Striking from a fortress hidden among the billion stars of the galaxy, rebel spaceships
      have won their first victory in a battle with the powerful Imperial Starfleet.
      The EMPIRE fears that another defeat could bring a thousand more solar systems into the
      rebellion, and Imperial control over the galaxy would be lost forever.
      To crush the rebellion once and for all, the EMPIRE is constructing a sinister new
      battle station. Powerful enough to destroy an entire planet, its completion spells
      certain doom for the champions of freedom."""

    val mappingResult = Func.mapping(text)

    mappingResult.take(5).foreach(println)

    val m1 = Map(("a" -> 1), ("b" -> 1))
    val m2 = Map(("a" -> 1), ("c" -> 2))
    println(Func.merge(m1, m2)) // Map(a -> 2, b -> 1, c -> 2))
  }
}

private object Func {

  def mapping(text: String): Array[(String, Int)] = {
    text
      .split(" ")
      .map(_.toLowerCase)
      .map(_.replaceAll("[^a-zA-Z0-9]", ""))
      .map(w => (w, 1))
  }

  def merge(m1: Map[String, Int], m2: Map[String, Int]): Map[String, Int] = {
    val keys = m1.keySet ++ m2.keySet
    val res = keys.map { k =>
      val v1 = m1.getOrElse(k, 0)
      val v2 = m2.getOrElse(k, 0)

      (k, v1 + v2)
    }.toMap
    res
  }

}
