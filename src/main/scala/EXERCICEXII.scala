object EXERCICEXII {
  def main(args: Array[String]): Unit = {
    // Première partie : articles communs
    val panier1 = List("Gâteau", "Lait", "Fromage", "Papier toilette")
    val panier2 = List("Pain", "Eau", "Jus de fruit", "Lait", "Fromage")
    val articlesCommuns = panier1.intersect(panier2)
    println("Articles communs aux deux paniers :")
    articlesCommuns.foreach(println)

    // Deuxième partie : fusion et formatage
    val liste1 = List("crayon", "stylo", "taille-crayon")
    val liste2 = List("livre de mathématiques", "livre français", "livre anglais")
    val listeCombinee = List(liste1, liste2)
    val listeAplat = listeCombinee.flatten

    listeAplat.foreach { item =>
      val article = if (item.startsWith("livre")) s"le $item" else s"un $item"
      println(s"$article est nécessaire dans la classe.")
    }
  }
}