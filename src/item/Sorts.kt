package item

import personnage.Personnage

class Sorts (
    var nom : String,
    var effet :(Personnage,Personnage)-> Unit,
) {

}
