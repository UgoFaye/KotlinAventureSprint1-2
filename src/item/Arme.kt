package item

import jeu.TirageDes
import personnage.Personnage

// Creation de la class Arme
class Arme (
    nom : String,
    description : String
)
    // Appel du parents Item
    :Item(nom,description)
{
    // Creation de la fonction calculerDegats
    fun calculerDegats (de: TirageDes, typesArmes: Types_armes, qualite: Qualite) : Int {
        var resultat = de.lance()
        if (resultat >= typesArmes.activationCritique) {
            resultat *= typesArmes.multiplicateurCritique

            println("Coup critique")
        }
        resultat += qualite.bonusRarete
        return resultat
    }

    // Creation de la fonction utiliser() pour les armes
    override fun utiliser (cible : Personnage) {

    }
}