import org.apache.spark.sql.SparkSession

object EXERCICEXV {
  def main(args: Array[String]): Unit = {
    // Initialisation de la SparkSession
    val spark = SparkSession.builder()
      .appName("EXERCICEXV")
      .master("local[*]")
      .getOrCreate()

    // 1. Charger le fichier Titanic.csv
    val df = spark.read
      .option("delimiter", ",")
      .option("header", "true")
      .csv("C:/Clone/Data/Titanic.csv")

    // 4. Transformer le DataFrame en RDD
    val rdd = df.rdd

    // 5. Afficher le nombre d'éléments
    println(s"Nombre total d'enregistrements: ${rdd.count()}")

    // 6. Afficher le premier élément
    val premierElement = rdd.first()
    println(premierElement)

    // 7. Afficher la première valeur du premier élément
    println(premierElement(0)) // ou premierElement.getString(0) selon le type

    // 8. Faire un sample de 5%
    val sampleRDD = rdd.sample(false, 0.05)
    println(s"Taille de l'échantillon: ${sampleRDD.count()}")

    // 9. Revenir au DataFrame original
    println("Affichage des premières lignes du DataFrame :")
    df.show() // Affiche les premières lignes

    // Création d'une vue temporaire
    df.createOrReplaceTempView("titanic")

    // Exécution d'une requête SQL
    println("Résultat de la requête SQL :")
    spark.sql("SELECT * FROM titanic").show()

    // Fermer la SparkSession à la fin
    spark.stop()

    /*10. on observe :
    df.show() affiche les 20 premières lignes du DataFrame par défaut.
     spark.sql("SELECT * FROM titanic").show() affiche le même résultat,
     mais en passant par une requête SQL.Cela confirme que la table temporaire titanic
     a bien été créée et est accessible via Spark SQL.
*/


      // 11. Analyse succincte avec des commandes SQL
    spark.sql("""
  SELECT
    Survived,
    COUNT(*) AS nombre_passagers,
    ROUND(AVG(Age), 1) AS age_moyen,
    ROUND(100.0 * COUNT(*) / (SELECT COUNT(*) FROM titanic), 1) AS pourcentage
  FROM titanic
  GROUP BY Survived
""").show()


  }
}