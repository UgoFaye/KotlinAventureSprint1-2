package personnage

import item.Arme
import item.Armure
import jeu.Jeu

// Creation de la classe Voleur
class Voleur (nom : String, pointDeVie : Int, pointDeVieMax : Int, attaque: Int, defense: Int, endurance: Int, vitesse: Int, armePrincipale: Arme?=null, armurePrincipale : Armure?) : Personnage(nom, pointDeVie, pointDeVieMax, attaque, defense, endurance, vitesse, armePrincipale, armurePrincipale) {
    fun volerItem(cible: Personnage) {
        for (i in cible.inventaire) {
            if (cible.inventaire.isEmpty()) {
                println("L'inventaire de l'adversaire est vide")
            }
            else {
                println("Choisissez un objet au hasard à voler (un chiffre)")
                var obj = readln().toInt()
                var item = cible.inventaire[obj]
                if (item == cible.armePrincipale) {
                    for (j in cible.inventaire) {
                        cible.inventaire.remove(item)
                        cible.armePrincipale = null
                        this.inventaire.add(item)
                    }
                }
                else if (item == cible.armurePrincipale) {
                    for (j in cible.inventaire) {
                        cible.inventaire.remove(item)
                        cible.armurePrincipale = null
                        this.inventaire.add(item)
                    }
                }
                else {
                    for (j in cible.inventaire) {
                        cible.inventaire.remove(item)
                        this.inventaire.add(item)
                    }
                }
                println("L'objet $item a été volé")
            }
        }
    }
    override fun toString(): String {
        return "Voleur ${super.toString()} (volerItem=${volerItem(cible = Personnage(nom, pointDeVie, pointDeVieMax, attaque, defense, endurance, vitesse, armePrincipale, armurePrincipale))})"
    }
}
