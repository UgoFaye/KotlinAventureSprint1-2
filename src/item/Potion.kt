package item

import personnage.Personnage

// Creation de la classe Potion
class Potion (
    nom : String,
    val soins : Int,
    description : String
)
    // Appel du parents Item
    :Item(nom,description)
{
    // Creation de la fonction utiliser () pour la potion
    override fun utiliser (cible:Personnage) {
        cible.boirePotion()
    }
}