import item.*
import jeu.Jeu
import personnage.Personnage

// Création des qualités des objets
val qualiteCommun = Qualite (
    "commun",
    0,
    "\u001B[32m"
)

val qualiteRare = Qualite (
    "rare",
    1,
    "\u001B[34m"
)

val qualiteEpic = Qualite (
    "epic",
    2,
    "\u001B[35m"
)

val qualiteLegendaire = Qualite (
    "legendaire",
    3,
    "\u001B[33m"
)

// Creation des armures
val typeArmureRembourree = TypeArmure (
    "Armure Rembourrée",
    1
)

val typeArmureCuir = TypeArmure (
    "Armure En cuir",
    2
)

val typeArmureCuirLoute = TypeArmure (
    "Armure En cuir Clouté",
    3
)

val typeArmureChemiseAChaine = TypeArmure (
    "Chemise à Chaîne",
    4
)

val typeArmurePectoral = TypeArmure (
    "Pectoral",
    5
)

val typeArmureCotteDeMaille = TypeArmure(
    "Cotte de Maille",
    6
)

// Creation des armes
val typesArmesDague = Types_armes (
    1,
    4,
    3,
    18
)

val typesArmesBaton = Types_armes (
    1,
    4,
    2,
    20
)

val typesArmesLance = Types_armes (
    1,
    8,
    3,
    20
)

val typesArmesArbaleteLegere = Types_armes (
    1,
    8,
    2,
    19
)

val typesArmesEpeeCourte = Types_armes (
    1,
    6,
    2,
    19
)

val typesArmesHache = Types_armes (
    1,
    8,
    3,
    20
)

val typesArmesEpeeLongue = Types_armes (
    1,
    8,
    2,
    19
)

val typesArmesMarteau = Types_armes (
    1,
    8,
    3,
    20
)

val typesArmesArclong = Types_armes (
    1,
    8,
    3,
    20
)


//TODO Sprint 2 : Création de sorts


fun main(args: Array<String>) {
    // Creation des armures
    val armure1 = Armure (
        "Armure en Cuir +2",
        "",
        typeArmureCuir,
        qualiteEpic
    )

    val armure2 = Armure (
        "Armure En Cuir Clouté +1",
        "",
        typeArmureCuirLoute,
        qualiteRare
    )

    // Creation des bombes
    val gregois = Bombe (
        4,
        6,
        "Feu grégois",
        "Une flasque qui contient un liquide inflammable."
    )

    val flasque = Bombe (
        2,
        8,
        "Flasque d’acide",
        "Une flasque qui contient une puissante substance corrosive."
    )

    val grenade = Bombe (
        5,
        6,
        "Grenade",
        "Une contraption qui explose une fois lancée."
    )

    //Creation des potions
    val potionSoin = Potion (
        "potion de soins",
        20,
        "Une potion qui contient un liquide rouge."
    )

    val grandePotionSoins = Potion (
        "Grande potion de soins",
        30,
        "Une grande potion qui contient un liquide rouge"
    )

    //Création des monstres
    val gobelin = Personnage(
        "Gobuta le gobelin",
        pointDeVie = 20,
        pointDeVieMax = 20,
        attaque = 5,
        defense = 4,
        vitesse = 11,
        endurance = 6
    )

    val mimique = Personnage(
        "geraldine la mimique",
        pointDeVie = 58,
        pointDeVieMax = 58,
        attaque = 14,
        defense = 10,
        endurance = 9,
        vitesse = 12
    )

    val oni = Personnage(
        "Lony l'oni",
        pointDeVie = 110,
        pointDeVieMax = 110,
        attaque = 19,
        defense = 16,
        endurance = 12,
        vitesse = 11
    )

    val dragon = Personnage(
        "lillie",
        pointDeVie = 195,
        pointDeVieMax = 195,
        attaque = 20,
        defense = 20,
        vitesse = 18,
        endurance = 20
    )

    val Cube_Gelatineux = Personnage(
        "Ghlub le cube gélatineux",
        pointDeVie = 84,
        pointDeVieMax = 84,
        attaque = 14,
        defense = 20,
        vitesse = 3,
        endurance = 6
    )

    val Grand_Dracosire_Diamantin = Personnage(
        "Angarster le Grand dracosire diamantin",
        pointDeVie = 507,
        pointDeVieMax = 507,
        attaque = 28,
        defense = 29,
        endurance = 24,
        vitesse = 30
    )

    val Farfadet = Personnage(
        "Danaé le Farfadet",
        pointDeVie = 18,
        pointDeVieMax = 18,
        attaque = 8,
        defense = 18,
        endurance = 12,
        vitesse = 18
    )

    //Ajout des monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf(gobelin, mimique, oni, dragon, Cube_Gelatineux, Grand_Dracosire_Diamantin,Farfadet))
    //Lancement du jeu
    jeu.lancerCombat()
}