package personnage

import item.Arme
import item.Armure
import java.security.Principal

// Creation de la classe guerrier
class Guerrier(nom : String, pointDeVie : Int, pointDeVieMax : Int, attaque :Int, defense : Int, endurance : Int, vitesse : Int, armePrincipal : Arme?=null, armurePrincipal : Armure, var armeSecondaireEquipee : Arme? = null) : Personnage (nom, pointDeVie, pointDeVieMax, attaque, defense, endurance, vitesse, armePrincipal, armurePrincipal) {
    fun guerrier(cible: Personnage) {
        //Creation de la classe equipe
        fun equipe (){
            println(
                "Dans quelle main voulez vous equiper l'arme : \n" +
                        "1 -> principale \n" +
                        "2 -> secondaire"
            )
            var choix: Int = readln().toInt()
            if (choix == 1) {
                this.equipe(arme = armePrincipale!!)
            }
            else if (choix == 2) {
                this.equipe(arme = armeSecondaireEquipee!!)
            }
        }
        fun attaque () {
            var atq = attaque(adversaire = cible)
            var degats = 1
            var bonusAtq = attaque/2
            calculTotalDefense()
            var degatsTotaux = 0
            if (this.armeSecondaireEquipee != null) {
                degats += armeSecondaireEquipee!!.calculerDegats()
                var degatsTotaux = degats + bonusAtq - cible.defense
            }
            else {
                var degatsTotaux = bonusAtq - cible.defense
            }
            if (degatsTotaux < 1) {
                degats = 1
            }
            var dgtCible = cible.pointDeVie - degatsTotaux
            println("vous avez infiger un total de degat de $dgtCible dégats")
        }
    }
    override fun toString():String{
        return "Guerrier ${super.toString()} (armeSecondaireEquipee=$armeSecondaireEquipee)"
    }
}



