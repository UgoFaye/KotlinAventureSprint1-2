package personnage

import item.*
import jeu.*

// Creation de la class Personnage
open class Personnage(
    val nom: String,
    var pointDeVie: Int,
    var pointDeVieMax: Int,
    var attaque: Int,
    var defense: Int,
    var endurance: Int,
    var vitesse: Int,
    var armePrincipale: Arme?=null,
    var armurePrincipale : Armure?
) {

    // Creation de l'inventaire
    var inventaire : MutableList <Item> = mutableListOf()

    // Creation de la fonction calculeDefense
    fun calculeDefense():Int{
        //TODO Mission 4.2
        return this.defense/2;
    }

    // Méthode pour attaquer un adversaire
    fun attaque(adversaire: Personnage) {
        //TODO Mission 4.1
        var degatBase= this.attaque/2
        var degatsArme = if (this.armePrincipale != null) degatBase += armePrincipale!!.calculerDegats() else 0
        adversaire.pointDeVie-=degatBase
        println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degatBase points de dégâts.")
    }

    // Création de la fonction equipe pour les armes
    fun equipe(arme: Arme){
        if (arme in inventaire){
            var armePrincipale = arme
        }
        println("$nom a equiper $armePrincipale")
    }

    // Création de la fonction avoirPotion
    fun avoirPotion() : Boolean {
        for (item in inventaire) {
            if (item  is Potion){
                return true
            }
        }
        return false
    }

    // Création de la fonction avoirBombe
    fun avoirBombe() : Boolean {
        for (item in inventaire) {
            if (item  is Bombe){
                return true
            }
        }
        return false
    }

    // Création de la fonction boirePotion
    fun boirePotion () {
        var pvEnPlus = 0
        if (avoirPotion() == true) {
            for (item in inventaire) {
                if(item is Potion){
                    pointDeVie += item.soins
                    if (pointDeVie > pointDeVieMax) {
                        pvEnPlus = pointDeVieMax - pointDeVie
                        pointDeVie = pointDeVieMax
                    }
                    inventaire.remove(item)
                    println("La potion ${item.nom} a ajouté $pvEnPlus")
                }
            }
        }
    }

    // Création de la fonction calcultotalDefense
    fun calculTotalDefense(): Int {
        var defBase = defense / 2
        return if (this.armurePrincipale != null) {
            defBase + armurePrincipale!!.calculProtection()
        } else  {
            defBase
        }
    }

    // Création de la fonction equipe pour les armures
    fun equipe(armure: Armure) {
        inventaire.add(armure)
        if (inventaire.contains(armure)) {
            this.armurePrincipale = armure
            println("$nom équipe ${armure.nom}")
        }else {
            println("impossible d'équiper ${armure.nom}")
        }
    }

    fun afficheInventaire() {
        println("inventaire de $nom")
        for (item in inventaire.withIndex()){
            println("${item.index} => ${item.value.nom}")
        }
    }

    fun loot(cible: Personnage){
        if (cible.pointDeVie <= 0){
            cible.armePrincipale = null
            cible.armurePrincipale = null
            this.inventaire.addAll(cible.inventaire)
            cible.inventaire = mutableListOf()
        }
    }

    override fun toString(): String {
        return "$nom (PV: $pointDeVie/$pointDeVieMax, Attaque: $attaque, Défense: $defense, Endurance: $endurance, Vitesse: $vitesse)"
    }
}