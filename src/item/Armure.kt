package item
import item.Qualite
import item.TypeArmure
import personnage.Personnage

// Creation de la class Armure
class  Armure (
    nom : String,
    description : String,
    var type:TypeArmure,
    var qualite: Qualite,
)
    // Appel du parents Item
    :Item(nom,description)
{
    // Creation de la fonction calculProtection
    fun calculProtection(): Int {
        var bonusProtection = this.type.bonusType + this.qualite.bonusRarete
        return bonusProtection
    }

    // Creation de la fonction utiliser pour l'armure
    override fun utiliser(cible: Personnage) {

    }
}
