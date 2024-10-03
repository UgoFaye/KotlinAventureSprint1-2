package jeu

import personnage.Personnage



class Jeu(monstres: List<Personnage>) {
    //Le personage du joueur
    lateinit var joueur: Personnage
    //La liste des monstre a combatre
     var combats: MutableList<Combat> = mutableListOf()
    //Le score
    var score: Int = 0

    // Corps du constructeur
    init {
        // Lancement de la création du personage du joueur
        this.creerPersonnage()
        // Pour chaque monstre dans la liste de monstres
        for (unMonstre in monstres){
            // On créer un combat
            val unCombat= Combat(this,unMonstre)
            combats.add(unCombat)
        }
    }

    fun lancerCombat() {
        for (unCombat in this.combats) {
            unCombat.executerCombat()
            // Mettre à jour le score en fonction du nombre de tours
            val tours = unCombat.nombreTours
            score += calculerScore(tours)
        }
        println("Score final du joueur: $score")
    }

    private fun calculerScore(tours: Int): Int {
        // Par exemple, vous pouvez attribuer plus de points pour moins de tours
        return 500 - tours * 10
    }

    /**
     *  Méthode pour créer le personnage du joueur en demandant les informations à l'utilisateur
     *
     */
    fun creerPersonnage(): Personnage {
        println("Création votre personnage:")
        //Mission 1.1
        println("Saisir le nom du perso:")
        var nom= readln()
        //initialisation des valeurs pour la boucle while
        var attaque = 0
        var defense = 0
        var endurance = 0
        var vitesse= 0
        var pointDeVieMax = 0
        var armePrincipale = null
        var armurePrincipale = null


        //mise en place d'une boucle do while pour la repartition des point d'attribut
        do {
            pointDeVieMax = 0
            var total = 40
            println("vous avez $total de point a placer")

            println("Combien de point(s) en attaque:")
            attaque = readln().toInt()
            total -= attaque
            if (total < 0) total = 0
            println("Il vous reste $total points")

            println("Combien de point(s) en défense:")
            var defense = readln().toInt()
            total -= defense
            if (total < 0) total = 0
            println("Il vous reste $total points")

            println("Combien de point(s) en endurance:")
            var endurance = readln().toInt()
            total -= endurance
            if (total < 0) total = 0
            println("Il vous reste $total points")

            println("Combien de point(s) en vitesse:")
            var vitesse = readln().toInt()
            total -= vitesse
            if (total < 0) total = 0
            println("Il vous reste $total points")

            pointDeVieMax = 50 + (endurance * 10)
            println("Vous avez $pointDeVieMax pv")

            if (attaque + defense + endurance + vitesse > 40) {
                total = 0
                println("Entrez une valeur correcte")
            }
        }
            while (attaque + defense + endurance + vitesse > 40)

        val hero = Personnage(nom,pointDeVieMax,pointDeVieMax,attaque,defense,endurance,vitesse,armurePrincipale,armurePrincipale)
        this.joueur= hero
        return hero
    }
    

}