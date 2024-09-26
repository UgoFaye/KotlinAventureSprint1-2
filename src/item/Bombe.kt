package item;

import personnage.Personnage
import kotlin.math.max

// Creation de la classe Bombe
class Bombe(
    val nombreDeDes : Int,
    val maxDe : Int,
    nom : String,
    description : String
)
    // Appel du parents Item
    :Item(nom,description)
{
    // Creation de la fonction utiliser() pour la bombe
    override fun utiliser (cible: Personnage) {
        var degat = nombreDeDes * maxDe
        var degatTotal = cible.calculeDefense() - degat
        degat = max(1, degat)
        cible.pointDeVie -= degat
    }
}





