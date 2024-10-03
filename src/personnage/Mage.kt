package personnage

import item.*
import personnage.*
import jeu.*
import java.util.Scanner

// Creation de la classe Mage
class Mage(nom : String, pointDeVie : Int, pointDeVieMax : Int, attaque : Int, defense : Int, endurance : Int, vitesse : Int, armePrincipale : Arme?=null, armurePrincipale : Armure?) : Personnage(nom, pointDeVie, pointDeVieMax, attaque, defense, endurance, vitesse, armePrincipale, armurePrincipale) {
    var grimoire :MutableList<Sorts> = mutableListOf()
    fun afficheGrimoire() {
        println("Grimoire de $nom")
        for (item in grimoire.withIndex()){
            println("${item.index} => ${item.value.nom}")
        }
    }
    fun choisirEtLancerSort(caster : Personnage, cible : Personnage) {
        println("Veuillez choisir un sort : ")
        afficheGrimoire()
        val scanner = Scanner(System.`in`)
        val choix = scanner.nextInt()

        if (choix in grimoire.indices) {
            val sortChoisi = grimoire[choix]
            println("choissez une cible : 0 pour joueur, 1 pour monstre")
            val cibleChoisie = scanner.nextInt()
            val cible = if (cibleChoisie == 0)  sortChoisi.effet(this,this) else sortChoisi.effet(this,cible)

        }


        
    }
}