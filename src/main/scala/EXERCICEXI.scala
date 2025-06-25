object EXERCICEXI {
  def main(args: Array[String]): Unit={
    val phrase = "Vanilla Donut 10 2.25"
    val partie = phrase.split(" ")
    val donut = partie.take(2).mkString(" ")
    val quantite = partie(2).toInt
    val prixUnitaire = partie(3).toDouble

    println(s"Type : $donut")
    println(s"Quantité : $quantite")
    println(s"Prix unitaire : $prixUnitaire")
  }
}