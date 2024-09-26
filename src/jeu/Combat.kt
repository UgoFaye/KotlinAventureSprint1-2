package jeu

import personnage.Personnage

class Combat(
    val jeu :Jeu,
    val monstre: Personnage
) {
    var nombreTours: Int = 1

    // Méthode pour simuler un tour de combat du joueur
    fun tourDeJoueur() {
        println("\u001B[34m ---Tour de ${this.jeu.joueur.nom} (pv: ${this.jeu.joueur.pointDeVie}) ---")

        // do..while pour les choix d'action possible
        do {
            println("Faites un choix : \n" +
                    "0. Passer votre tour \n" +
                    "1. Attaquer \n")
            var choix : Int = readln().toInt()
            if (choix == 1) {
                this.jeu.joueur.attaque(monstre)
            }
            else if (choix == 0) {
                println("Vous passez votre tour")
            }
            else {
                println("Entrez une valeur correcte")
            }
        }
            while (choix != 0 && choix != 1)

        println("\u001b[0m")
    }

    // Méthode pour simuler un tour de combat du monstre
    fun tourDeMonstre() {
        println("\u001B[31m---Tour de ${monstre.nom} (pv: ${monstre.pointDeVie}) ---")
       //Création de la variable résultat pour le lancé de dé
        var resultat = TirageDes(1,100).lance()
        //ajout d'un if pour déterminer le tour du monstre et son action
        if (resultat <= 70) {
            this.monstre.attaque(this.jeu.joueur)
        }else println("${monstre.nom} passe son tour !")

        println("\u001b[0m")
    }

    // Méthode pour exécuter le combat complet
    fun executerCombat() {
        println("Début du combat : ${this.jeu.joueur.nom} vs ${monstre.nom}")
        //La vitesse indique qui commence
        var tourJoueur = this.jeu.joueur.vitesse >= this.monstre.vitesse
        //Tant que le joueur et le monstre sont vivants
        while (this.jeu.joueur.pointDeVie > 0 && monstre.pointDeVie > 0) {
            println("Tours de jeu : ${nombreTours}")
            if (tourJoueur) {
                tourDeJoueur()
            } else {
                tourDeMonstre()
            }
            nombreTours++
            tourJoueur = !tourJoueur // Alternance des tours entre le joueur et le monstre
            println("${this.jeu.joueur.nom}: ${this.jeu.joueur.pointDeVie} points de vie | ${monstre.nom}: ${monstre.pointDeVie} points de vie")
            println("")
        }

        if (this.jeu.joueur.pointDeVie <= 0) {
            println("Game over ! ${this.jeu.joueur.nom} a été vaincu !")
            println("Le combat recommence")

            this.jeu.joueur.pointDeVie = this.jeu.joueur.pointDeVieMax
            this.monstre.pointDeVie = this.monstre.pointDeVieMax
            this.executerCombat()
        } else {
            println("BRAVO ! ${monstre.nom} a été vaincu !")
        }
    }
}